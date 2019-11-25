package com.leetcode.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;
    private int x;
    private Semaphore semaphore1;
    private Semaphore semaphore2;
    private Semaphore semaphore3;
    private Semaphore semaphore4;

    public ZeroEvenOdd(int n) {
        this.n = n;
        x = 1;
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(0);
        semaphore3 = new Semaphore(0);
        semaphore4 = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(true){
            semaphore1.acquire();
            if(x > n){
                semaphore2.release();
                semaphore4.release();
                return;
            }
            printNumber.accept(0);
//            System.out.println(0);
            semaphore2.release();
            semaphore3.acquire();
            if(x > n){
                semaphore2.release();
                semaphore4.release();
                return;
            }
            printNumber.accept(0);
//            System.out.println(0);

            semaphore4.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(true){
            semaphore2.acquire();
            if(x > n){
                semaphore3.release();
                return;
            }
            printNumber.accept(x++);
//            System.out.println(x++);

            semaphore3.release();

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(true){
            semaphore4.acquire();
            if(x > n){
                semaphore1.release();
                return;
            }
            printNumber.accept(x++);
//            System.out.println(x++);

            semaphore1.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(() -> {
            try {
                zeroEvenOdd.zero(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                zeroEvenOdd.even(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            try {
                zeroEvenOdd.odd(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutdown();
    }

}
