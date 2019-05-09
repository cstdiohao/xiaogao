package com.nihao.xiagao.study;


import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    private int begin;
    private int end;

    public MyRecursiveTask(int begin, int end){
        this.begin = begin;
        this.end = end;
    }

    protected Integer compute() {
        if(begin - end > 1000){
            int mid = (begin + end) / 2;
            MyRecursiveTask left = new MyRecursiveTask(begin, mid);
            MyRecursiveTask right = new MyRecursiveTask(mid + 1, end);
            return left.join() + right.join();
        } else {
            int sum = 0;
            for(int i = begin; i <= end; i++){
                sum += i;
            }
            return sum;
        }
    }


}
