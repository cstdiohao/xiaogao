package com.nihao.service;

import com.nihao.bean.IdBuffer;
import com.nihao.bean.IdPage;
import com.nihao.entity.IdRecord;
import com.nihao.mapper.IdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class IdService {
    @Autowired
    private IdMapper idMapper;

    private Map<String, IdBuffer> idMap = new ConcurrentHashMap<>();
    private volatile boolean inited = false;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @PostConstruct
    public void init(){
        updateFromDB();
        inited = true;
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {updateFromDB();}, 60, 60, TimeUnit.SECONDS);
    }

    private void updateFromDB(){
        List<IdRecord> idRecords = idMapper.getAll();
        Set<String> removeKeySet = new HashSet<>(idMap.keySet());
        for(IdRecord idRecord : idRecords){
            if(idMap.containsKey(idRecord.getKey())){
                removeKeySet.remove(idRecord.getKey());
            }else{
                idMap.put(idRecord.getKey(), new IdBuffer(idRecord.getKey()));
            }
        }
        for(String key : removeKeySet){
            idMap.remove(key);
        }
    }

    public Long get(String key){
        while(!inited){
            return -1L;
        }
        if(idMap.containsKey(key)){
            IdBuffer idBuffer = idMap.get(key);
            if(!idBuffer.isInited()){
                synchronized (idBuffer){
                    if(!idBuffer.isInited()){
                        updateIdPage(idBuffer.getPages()[idBuffer.getNowPageIndex()]);
                        idBuffer.setInited(true);
                    }
                }
            }
            return getFromBuffer(idBuffer);
        }else{
            return -1L;
        }
    }

    private Long getFromBuffer(IdBuffer idBuffer){
        try{
            idBuffer.getReadLock().lock();
            IdPage idPage = idBuffer.getPages()[idBuffer.getNowPageIndex()];
            Long id = idBuffer.getId();

            if(idPage.getMaxValue() - id < 0.5 * IdPage.pageSize && !idBuffer.isNextReady() && idBuffer.getIsUpdating().compareAndSet(false, true)){
                executorService.submit(() -> {
                    boolean finishUpdate = false;
                    try {
                        IdPage idPage1 = idBuffer.getPages()[1 - idBuffer.getNowPageIndex()];
                        updateIdPage(idPage1);
                    }finally {
                        if(finishUpdate){
                            idBuffer.getWriteLock().lock();
                            idBuffer.setNextReady(true);
                            idBuffer.getIsUpdating().set(false);
                            idBuffer.getWriteLock().lock();
                        }else {
                            idBuffer.getWriteLock().lock();
                            idBuffer.getIsUpdating().set(false);
                            idBuffer.getWriteLock().unlock();
                        }
                    }
                    idBuffer.setNextReady(true);
                    idBuffer.getIsUpdating().set(false);
                });
            }
            if(id < idPage.getMaxValue()){
                return id;
            }
        }finally {
            idBuffer.getReadLock().unlock();
        }

        waitUpdateFinish(idBuffer);
        try{
            idBuffer.getWriteLock().lock();
            IdPage idPage = idBuffer.getPages()[idBuffer.getNowPageIndex()];
            Long id = idPage.getId().getAndIncrement();
            if(id < idPage.getMaxValue()){
                return id;
            }
            if(idBuffer.isNextReady()){
                idBuffer.setNowPageIndex(1 - idBuffer.getNowPageIndex());
                idBuffer.setNextReady(false);
            }
        }finally {
            idBuffer.getWriteLock().unlock();
        }
        return getFromBuffer(idBuffer);
    }

    private void waitUpdateFinish(IdBuffer idBuffer){
        while(idBuffer.getIsUpdating().get()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateIdPage(IdPage idPage){
        String key = idPage.getIdBuffer().getKey();
        IdRecord idRecord = getAndUpdate(key);
        idPage.setId(new AtomicLong(idRecord.getIndex()));
        idPage.setMaxValue(idPage.getId().get() + IdPage.pageSize);
    }

    @Transactional
    public IdRecord getAndUpdate(String key){
        IdRecord idRecord = idMapper.get(key);
        idMapper.increase(key, IdPage.pageSize);
        return idRecord;
    }
}
