package com.nihao.controller;

import com.nihao.bean.TestParam;
import com.nihao.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("id")
public class IdController {
    @Autowired
    private IdService idService;

    @RequestMapping(value = "/{key}", method = RequestMethod.POST)
    public Long get(@PathVariable(value = "key") String key,
                    @RequestHeader("header1") String header,
                    @RequestBody TestParam param){
        return idService.get(key);
    }

}
