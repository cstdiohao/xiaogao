package com.demo.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private FeignDemoService feignDemoService;

    @RequestMapping(value = "/feign/test", method = RequestMethod.GET)
    public String test(){
        return feignDemoService.index("header", 123L);
    }

}
