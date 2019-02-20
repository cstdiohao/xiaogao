package com.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String index(@RequestHeader("header") String header, Long id){
        return header + " " + id;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public JSONObject test(@RequestHeader("header") String header, JSONObject body){
        body.put("header", header);
        return body;
    }



}
