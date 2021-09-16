package com.dongmingdi.sync;

// synchronized 实现线程间通信
class Share {
    private int number = 0;

    // +1
    public synchronized void incr() throws InterruptedException {
        // 解决虚假唤醒
        while (number != 0) {
            this.wait();
        }
        number ++;
        System.out.println(Thread.currentThread().getName() + "++" + number);
        this.notifyAll();
    }

    // -1
    public synchronized void decr() throws InterruptedException{
        while (number != 1) {
            this.wait();
        }
        number --;
        System.out.println(Thread.currentThread().getName() + "--" + number);
        this.notifyAll();
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(() -> {
            for (int i = 0; i < 10; i ++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i ++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i ++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i ++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }
}
