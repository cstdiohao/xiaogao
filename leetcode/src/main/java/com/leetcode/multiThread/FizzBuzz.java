package com.leetcode.multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private int i;
    private ReentrantLock lock;
    private Condition condition;

    public FizzBuzz(int n) {
        this.n = n;
        i = 1;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        while(i <= n){
            while(i % 3 != 0 || i % 5 == 0){
                condition.await();
                if(i > n){
                    lock.unlock();
                    return;
                }
            }
            printFizz.run();
            i++;
            condition.signalAll();
        }
        lock.unlock();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        while(i <= n){
            while(i % 5 != 0 || i % 3 == 0){
                condition.await();
                if(i > n){
                    lock.unlock();
                    return;
                }
            }
            printBuzz.run();
            i++;
            condition.signalAll();
        }
        lock.unlock();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        while(i <= n){
            while(i % 3 != 0 || i % 5 != 0){
                condition.await();
                if(i > n){
                    lock.unlock();
                    return;
                }
            }
            printFizzBuzz.run();
            i++;
            condition.signalAll();
        }
        lock.unlock();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while(i <= n){
            while(i % 3 == 0 || i % 5 == 0){
                condition.await();
                if(i > n){
                    lock.unlock();
                    return;
                }
            }
            printNumber.accept(i);
            i++;
            condition.signalAll();
        }
        lock.unlock();
    }

}
