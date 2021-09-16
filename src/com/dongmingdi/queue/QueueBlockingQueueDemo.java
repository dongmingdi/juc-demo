package com.dongmingdi.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<String> blockingDeque = new ArrayBlockingQueue<>(3);
//        System.out.println(blockingDeque.add("a"));
//        System.out.println(blockingDeque.add("b"));
//        System.out.println(blockingDeque.add("c"));
////        System.out.println(blockingDeque.element());
////        System.out.println(blockingDeque.add("w"));
//
//        System.out.println(blockingDeque.remove());
//        System.out.println(blockingDeque.remove());
//        System.out.println(blockingDeque.remove());
////        System.out.println(blockingDeque.remove());
//
//        System.out.println(blockingDeque.offer("a"));
//        System.out.println(blockingDeque.offer("b"));
//        System.out.println(blockingDeque.offer("c"));
//        System.out.println(blockingDeque.offer("w"));
//        System.out.println(blockingDeque.poll());
//        System.out.println(blockingDeque.poll());
//        System.out.println(blockingDeque.poll());
//        System.out.println(blockingDeque.poll());

//        blockingDeque.put("a");
//        blockingDeque.put("b");
//        blockingDeque.put("c");
////        blockingDeque.put("d");
//        System.out.println(blockingDeque.take());
//        System.out.println(blockingDeque.take());
//        System.out.println(blockingDeque.take());
//        System.out.println(blockingDeque.take());
        System.out.println(blockingDeque.offer("a"));
        System.out.println(blockingDeque.offer("b"));
        System.out.println(blockingDeque.offer("c"));
        System.out.println(blockingDeque.offer("w", 3L, TimeUnit.SECONDS));
    }
}
