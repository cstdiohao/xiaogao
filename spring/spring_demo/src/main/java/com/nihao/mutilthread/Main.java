package com.nihao.mutilthread;


import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        for(int i = 0; i < 10; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId());
                    Thread.currentThread().stop();
                    System.out.println(Thread.currentThread().getId() + "____");
                }
            });
        }
        service.shutdown();

    }

    private static void run1(){
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int threadNum = 0;
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 50; i++){
            executorService.execute(new ThreadTest(countDownLatch, threadNum++));
        }
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    executorService.shutdown();
                    Boolean result = executorService.awaitTermination(10, TimeUnit.SECONDS);
                    System.out.println("result is : " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        countDownLatch.countDown();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

}
