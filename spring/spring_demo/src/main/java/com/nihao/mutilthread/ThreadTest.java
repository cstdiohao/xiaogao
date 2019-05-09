package com.nihao.mutilthread;

import java.util.concurrent.CountDownLatch;

public class ThreadTest implements Runnable{
    private CountDownLatch countDownLatch;
    private int threadNum;

    public ThreadTest(CountDownLatch countDownLatch, int threadNum){
        this.countDownLatch = countDownLatch;
        this.threadNum = threadNum;
    }

    public void run(){
        int i = 0;
        try {
            countDownLatch.await();
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);
            System.out.println("Thread " + threadNum + " log " + i++);
            Thread.sleep(200);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
