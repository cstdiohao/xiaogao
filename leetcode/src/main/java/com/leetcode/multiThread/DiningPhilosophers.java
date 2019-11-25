package com.leetcode.multiThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class DiningPhilosophers {
    private Semaphore[] semaphores;

    public DiningPhilosophers() {
        semaphores = new Semaphore[5];
        for(int i = 0; i < 5; ++i){
            semaphores[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while(true) {
            if (semaphores[philosopher].tryAcquire(10 + philosopher, TimeUnit.MILLISECONDS)) {
                if (semaphores[(philosopher + 1) % 5].tryAcquire(10 + philosopher, TimeUnit.MILLISECONDS)) {
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    putRightFork.run();
                    semaphores[philosopher].release();
                    semaphores[(philosopher + 1) % 5].release();
                    return;
                } else {
                    semaphores[philosopher].release();
                }
            }
        }

    }
}
