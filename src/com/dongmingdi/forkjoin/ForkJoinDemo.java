package com.dongmingdi.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class MyTask extends RecursiveTask<Integer> {

    // 计算10以内的运算
    private static final Integer VALUE = 10;

    private int begin;
    private int end;
    private int result;

    // 创建有参构造
    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if((end - begin) < VALUE) {
            // 相加操作
            for (int i = begin; i <= end; i++) {
                result += i;
            }
        } else {
            // 继续拆分
            int middle = (begin+end)/2;
            MyTask task1 = new MyTask(begin, middle);
            MyTask task2 = new MyTask(middle+1, end);
            // 调用方法拆分
            task1.fork();
            task2.fork();
            result = task1.join() + task2.join();
        }
        return result;
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(1, 100);
        // 创建分支合并池对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
        Integer result = forkJoinTask.get();
        System.out.println(result);
        forkJoinPool.shutdown();
    }
}
