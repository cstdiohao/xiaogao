package com.leetcode.multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FooBar {
    private int n;
    private Object lock;
    CountDownLatch countDownLatch;

    public FooBar(int n) {
        this.n = n;
        lock = new Object();
        countDownLatch = new CountDownLatch(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        countDownLatch.await();
        synchronized (lock) {
            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lock.notify();
                lock.wait();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        synchronized (lock) {
            countDownLatch.countDown();
            for (int i = 0; i < n; i++) {
                lock.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(5);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutdown();
    }

}
