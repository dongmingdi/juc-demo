package com.dongmingdi.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 测试runnable和callable的区别
class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("runnable ....");
    }
}

class MyThread2 implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " come in callable");
        return 200;
    }
}

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new MyThread1(), "AA").start();
        // FutureTask
        FutureTask<Integer> futureTask1 = new FutureTask<>(new MyThread2());
        FutureTask<Integer> futureTask2 = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName() + " come in callable");
            return 1024;
        });
        new Thread(futureTask2, "lucy").start();
        new Thread(futureTask1, "mary").start();

        while (!futureTask2.isDone()) {
            System.out.println("wait ...");
        }
        System.out.println(futureTask2.get());
        System.out.println(futureTask2.get());

        System.out.println(Thread.currentThread().getName() + " come over");
        // FutureTask原理 未来任务
    }
}
