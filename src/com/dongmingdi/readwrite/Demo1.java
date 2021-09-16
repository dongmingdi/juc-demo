package com.dongmingdi.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

// 锁降级
public class Demo1 {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        // 获取写锁
        writeLock.lock();
        System.out.println("dongmingdi");
        // 获取读锁
        readLock.lock();
        System.out.println("--read");

        // 释放写锁
        writeLock.unlock();

        // 释放读锁
        readLock.unlock();
    }
}
