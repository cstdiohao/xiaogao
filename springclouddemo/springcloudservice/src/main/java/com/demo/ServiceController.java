package com.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String index(){
        return "Hi,dy_bom! this is  provider-node1 of peer!";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@RequestHeader("aaa") String aaa){
        return aaa;
    }

}
