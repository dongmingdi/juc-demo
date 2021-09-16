package com.dongmingdi.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// 循环栅栏
public class CyclicBarrierDemo {
    private static final int NUMBER = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, ()->{
            System.out.println("集齐七颗龙珠召唤神龙");
        });

        for (int i = 1; i <= 7; i++ ) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + " 星龙珠被收集到了");
                    cyclicBarrier.await(); // 达到屏障点 程序往下执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
