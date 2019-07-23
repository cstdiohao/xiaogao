package com.nihao.bean;

import java.util.concurrent.atomic.AtomicLong;

public class IdPage {
    public static int pageSize = 10;
    private AtomicLong id;
    private Long maxValue;
    private IdBuffer idBuffer;

    public IdPage(IdBuffer idBuffer){
        this.idBuffer = idBuffer;
    }

    public AtomicLong getId() {
        return id;
    }

    public void setId(AtomicLong id) {
        this.id = id;
    }

    public Long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }

    public IdBuffer getIdBuffer() {
        return idBuffer;
    }

    public void setIdBuffer(IdBuffer idBuffer) {
        this.idBuffer = idBuffer;
    }
}
