package com.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.RetryLoadBalancerInterceptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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

        RestTemplate restTemplate1 = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("header", "testHeader");
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("id", 123);
        HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(jsonObject, headers);
        return restTemplate.exchange("http://EUREKA-SERVICE/get", HttpMethod.GET, entity, String.class).getBody();

//        MultiValueMap<String, Object> parammap = new LinkedMultiValueMap<String, Object>();
//        HttpEntity<Map> entity = new HttpEntity<Map>(parammap,headers);
//        restTemplate.postForObject("http://EUREKA-SERVICE/test", entity, String.class);
//        System.out.println(123);
//        return restTemplate.getForEntity("http://EUREKA-SERVICE/add", String.class).getBody();
    }

}
