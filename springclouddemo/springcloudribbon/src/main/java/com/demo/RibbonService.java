package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
//        restTemplate.postForEntity("http://EUREKA-SERVICE/get", null, String.class, "aaa");
        HttpHeaders headers = new HttpHeaders();
        headers.add("aaa", "bbb");

        MultiValueMap<String, Object> parammap = new LinkedMultiValueMap<String, Object>();
        HttpEntity<Map> entity = new HttpEntity<Map>(parammap,headers);
        restTemplate.postForObject("http://EUREKA-SERVICE/test", entity, String.class);
        System.out.println(123);
        return restTemplate.getForEntity("http://EUREKA-SERVICE/add", String.class).getBody();
    }

}
