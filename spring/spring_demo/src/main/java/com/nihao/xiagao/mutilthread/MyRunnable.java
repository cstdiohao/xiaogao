package com.nihao.xiagao.mutilthread;

public class MyRunnable implements Runnable {
    private MyLock lock;
    public MyRunnable(MyLock lock){
        this.lock = lock;
    }

    public void run(){
        lock.lock();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

}
