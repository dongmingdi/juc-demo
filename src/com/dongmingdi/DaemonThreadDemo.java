package com.dongmingdi;

public class DaemonThreadDemo {
    // 测试守护线程和用户线程
    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");
        aa.setDaemon(true);
        aa.start();
        // 设置成守护线程
        System.out.println(Thread.currentThread().getName() + "over");
    }
}
