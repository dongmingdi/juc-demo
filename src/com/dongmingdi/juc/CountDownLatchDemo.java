package com.dongmingdi.juc;

import java.util.concurrent.CountDownLatch;

// 减少计数
public class CountDownLatchDemo {
    // 六个同学离开教室后 班长才可以锁门
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 班长锁门走人了");
    }
}
