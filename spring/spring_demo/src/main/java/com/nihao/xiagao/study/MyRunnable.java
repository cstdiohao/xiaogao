package com.nihao.xiagao.study;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable implements Runnable {
    public static AtomicInteger num = new AtomicInteger(0);


    public void run(){
        num.incrementAndGet();
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        num.decrementAndGet();
    }
}
