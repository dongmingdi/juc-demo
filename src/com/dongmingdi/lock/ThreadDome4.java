package com.dongmingdi.lock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

// 演示集合线程不安全 及解决
public class ThreadDome4 {
    public static void main(String[] args) {
        // 演示List
//        List<String> list = new ArrayList<>(); // 因为add方法没有synchronized关键字
//        List<String> list = new Vector<>(); // 通过Vector 解决
//        List<String> list = Collections.synchronizedList(new ArrayList<>()); // 利用Collections工具类解决
//        List<String> list = new CopyOnWriteArrayList<>(); // 利用CopyOnWriteArrayList解决 写时复制技术 并发读 独立写
//        // 写之前先复制一个和之前相同大小的区域 写自己的内容 然后和原数据合并 然后让其他线程读新集合中的内容 既兼顾了并发读 又兼顾独立写
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0, 8));
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }

        // 演示HashSet
//        Set<String> set = new HashSet<>(); // 因为add方法没有synchronized关键字
//        Set<String> set = new CopyOnWriteArraySet<>(); // 利用CopyOnWriteArraySet解决
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                set.add(UUID.randomUUID().toString().substring(0, 8));
//                System.out.println(set);
//            }, String.valueOf(i)).start();
//        }

        // 演示HashMap
//        Map<String, String> map = new HashMap<>(); // 因为put方法没有synchronized关键字
        Map<String, String> map = new ConcurrentHashMap<>(); // 利用ConcurrentHashMap解决
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            new Thread(() -> {
                String key = String.valueOf(finalI);
                map.put(key, UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
