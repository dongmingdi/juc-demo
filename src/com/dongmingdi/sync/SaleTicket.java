package com.dongmingdi.sync;

// synchronized实现卖票
class Ticket {
    // 票数
    private int num = 30;

    // 买票方法
    public synchronized void sale() {
        // 只有票大于0能卖
        if(num > 0) {
            System.out.println(Thread.currentThread().getName() + "：卖出：" + (num --) + "剩下：" + num);
        }
    }
}

public class SaleTicket {
    // 创建多个线程 3个售票员
    public static void main(String[] args) {
        // 创建ticket对象
        Ticket ticket = new Ticket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "AA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "BB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }
        }, "CC").start();
    }
}
