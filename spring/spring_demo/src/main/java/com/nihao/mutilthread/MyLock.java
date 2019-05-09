package com.nihao.mutilthread;

import java.util.concurrent.locks.ReentrantLock;

public class MyLock {
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void lock(){
        System.out.println(Thread.currentThread().getId() + " lock begin");
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getId() + " lock end");
    }

    public void unlock(){
        System.out.println(Thread.currentThread().getId() + " unlock begin");
        reentrantLock.unlock();
        System.out.println(Thread.currentThread().getId() + " unlock end");
    }


}
