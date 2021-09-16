package com.dongmingdi.lock;

import java.util.concurrent.locks.ReentrantLock;

// 可重入锁实现卖票 Lock接口
class LTicket {
    private int number = 30;

    //建可重入锁
    private final ReentrantLock lock = new ReentrantLock(true); // true 公平锁 false 非公平锁 默认非公平

    public void sale() {
        lock.lock();
        try {
            if(number > 0) {
                System.out.println(Thread.currentThread().getName() + "：卖出：" + (number --) + "剩下：" + number);
            }
        } finally {
            lock.unlock();
        }
    }
}

public class LSaleTicket {

    public static void main(String[] args) {
        LTicket ticket = new LTicket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "CC").start();
    }
}
