package com.nihao.bean;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class IdBuffer {
    private volatile boolean inited;
    private AtomicBoolean isUpdating = new AtomicBoolean(false);
    private String key;
    private IdPage[] pages = new IdPage[]{new IdPage(this), new IdPage(this)};
    private volatile boolean isNextReady;
    private int nowPageIndex;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public IdBuffer(){}

    public IdBuffer(String key){
        this.key = key;
    }

    public Long getId(){
        return pages[nowPageIndex].getId().getAndIncrement();
    }

    public AtomicBoolean isUpdating() {
        return isUpdating;
    }

    public void setUpdating(AtomicBoolean updating) {
        isUpdating = updating;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isInited() {
        return inited;
    }

    public void setInited(boolean inited) {
        this.inited = inited;
    }

    public AtomicBoolean getIsUpdating() {
        return isUpdating;
    }

    public void setIsUpdating(AtomicBoolean isUpdating) {
        this.isUpdating = isUpdating;
    }

    public IdPage[] getPages() {
        return pages;
    }

    public void setPages(IdPage[] pages) {
        this.pages = pages;
    }

    public boolean isNextReady() {
        return isNextReady;
    }

    public void setNextReady(boolean nextReady) {
        isNextReady = nextReady;
    }

    public int getNowPageIndex() {
        return nowPageIndex;
    }

    public void setNowPageIndex(int nowPageIndex) {
        this.nowPageIndex = nowPageIndex;
    }

    public Lock getReadLock(){
        return lock.readLock();
    }

    public Lock getWriteLock(){
        return lock.writeLock();
    }
}
