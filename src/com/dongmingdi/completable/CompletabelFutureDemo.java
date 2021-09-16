package com.dongmingdi.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletabelFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName() + "completableFuture1");
        });
        completableFuture1.get();
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName() + "completableFuture2");
//            int i = 10 / 0;
            return 1024;
        });
        completableFuture2.whenComplete((t, u)->{
            System.out.println("----t=" + t);
            System.out.println("----u=" + u);
        });
    }
}
