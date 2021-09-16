package com.dongmingdi.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 演示线程池的三种常用分类
public class ThreadPoolDome1 {
    public static void main(String[] args) {
        // 一池N线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        // 一池一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        // 可扩容线程池
        ExecutorService threadPool3 = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 20; i++) {
                threadPool3.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool3.shutdown();
        }


    }
}
