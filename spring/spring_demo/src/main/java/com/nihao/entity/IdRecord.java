package com.nihao.entity;

import java.io.Serializable;

public class IdRecord implements Serializable {
    private static final long serialVersionUID = 131677849378131672L;

    private Long id;
    private String key;
    private Long index;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }
}
