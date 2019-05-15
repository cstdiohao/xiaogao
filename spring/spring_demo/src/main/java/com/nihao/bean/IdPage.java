package com.nihao.bean;

import java.util.concurrent.atomic.AtomicLong;

public class IdPage {
    public static int pageSize = 50;

    private volatile boolean isUpdating;
    private AtomicLong id;
    private Long upperLimit;
    private String key;

    public IdPage(){}

    public IdPage(AtomicLong id, Long upperLimit, String key){
        this.id = id;
        this.upperLimit = upperLimit;
        this.key = key;
    }

    public AtomicLong getId() {
        return id;
    }

    public void setId(AtomicLong id) {
        this.id = id;
    }

    public Long getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Long upperLimit) {
        this.upperLimit = upperLimit;
    }

    public boolean isUpdating() {
        return isUpdating;
    }

    public void setUpdating(boolean updating) {
        isUpdating = updating;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
