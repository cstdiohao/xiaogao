package com.nihao.mapper;

import com.nihao.entity.IdRecord;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface IdMapper {
    IdRecord get(String key);
    void update(IdRecord idRecord);
}
