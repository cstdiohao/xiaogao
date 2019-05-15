package com.nihao.controller;

import com.nihao.entity.IdRecord;
import com.nihao.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("id")
public class IdController {
    @Autowired
    private IdService idService;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public Long get(@PathVariable(value = "key") String key){
        return idService.get(key);
    }
}
