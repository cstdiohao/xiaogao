package com.nihao.xiagao.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    @Autowired
    private MyTestBean myTestBean;

    public MyTestBean getMyTestBean() {
        return myTestBean;
    }

    public void setMyTestBean(MyTestBean myTestBean) {
        this.myTestBean = myTestBean;
    }
}
