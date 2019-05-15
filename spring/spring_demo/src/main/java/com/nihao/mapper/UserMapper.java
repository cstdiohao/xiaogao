package com.nihao.mapper;

import com.nihao.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User sel(int id);

}
