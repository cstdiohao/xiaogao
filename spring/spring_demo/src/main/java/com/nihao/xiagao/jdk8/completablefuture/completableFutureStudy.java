package com.nihao.xiagao.jdk8.completablefuture;

import java.util.concurrent.CompletableFuture;

public class completableFutureStudy {

    public static void main(String[] args) throws Exception{
        System.out.println(CompletableFuture.supplyAsync(()-> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).handleAsync((v, e)->{
            System.out.println(Thread.currentThread().getName());
            if(e == null){
                return ++v;
            }else{
                return -100;
            }
        }).get());
    }

}
