package com.nihao.controller;

import com.nihao.entity.User;
import com.nihao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public User get(@PathVariable int id){
        return userService.sel(id);
    }

}
