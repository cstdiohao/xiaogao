package com.nihao.service;

import com.nihao.entity.User;
import com.nihao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User sel(int id){
        return userMapper.sel(id);
    }
}
