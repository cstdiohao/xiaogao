package com.nihao.service;

import com.nihao.bean.IdPage;
import com.nihao.entity.IdRecord;
import com.nihao.mapper.IdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class IdService {
    @Autowired
    private IdMapper idMapper;
    @Autowired
    private IdPageService idPageService;

    private Map<String, IdPage> idMap = new ConcurrentHashMap<>();
    //用来占位，如果idMap中的value是它，则说明对应的key正在被初始化
    private IdPage emptyIdPage = new IdPage();

    public Long get(String key){
        if(!idMap.containsKey(key)){
            synchronized (this){
                if(!idMap.containsKey(key)){
                    IdRecord idRecord = idMapper.get(key);
                    IdPage idPage = new IdPage(new AtomicLong(idRecord.getIndex()), idRecord.getIndex() + IdPage.pageSize, key);
                    idRecord.setIndex(idRecord.getIndex() + IdPage.pageSize);
                    idMapper.update(idRecord);
                    idMap.put(key, idPage);
                }
            }
        }
        IdPage idPage = idMap.get(key);
        AtomicLong atomicLong = idPage.getId();
        Long id = atomicLong.getAndIncrement();
        if(id >= idPage.getUpperLimit()){
            synchronized (idPage) {
                if (id > idPage.getUpperLimit() && !idPage.isUpdating()) {
                    idPage.setUpdating(true);
                    idPageService.updateIdPage(idPage);
                }
            }
            while(id >= idPage.getUpperLimit()){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }
}
