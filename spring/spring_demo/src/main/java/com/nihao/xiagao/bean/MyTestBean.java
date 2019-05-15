package com.nihao.xiagao.bean;

import org.springframework.stereotype.Component;

@Component
public class MyTestBean {
    private String name = "abc";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
