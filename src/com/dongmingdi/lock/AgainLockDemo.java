package com.dongmingdi.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Lock实现可重入锁
public class AgainLockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " 外层");
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + " 内层");
                } finally {
                    lock.unlock();
                }
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(()->{
            lock.lock();
            System.out.println("aaa");
            lock.unlock();
        }, "aa").start();
    }
}
