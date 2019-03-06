package com.demo.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "eureka-service")
public interface FeignDemoService {

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    String index(@RequestHeader("header") String header, @PathVariable("id") Long id);

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    JSONObject test(@RequestHeader("header") String header, JSONObject body);

}
