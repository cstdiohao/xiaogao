package com.nihao.service;

import com.nihao.bean.IdPage;
import com.nihao.entity.IdRecord;
import com.nihao.mapper.IdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class IdPageService {
    @Autowired
    private IdMapper idMapper;

    private ExecutorService executorService = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000), new ThreadPoolExecutor.CallerRunsPolicy());

    public void updateIdPage(IdPage idPage){
        executorService.submit(() -> {
            String key = idPage.getKey();
            IdRecord idRecord = idMapper.get(key);
            idRecord.setIndex(idRecord.getIndex() + IdPage.pageSize);
            idMapper.update(idRecord);
            idPage.setUpperLimit(idPage.getUpperLimit() + IdPage.pageSize);
            idPage.setUpdating(false);
        });
    }

}
