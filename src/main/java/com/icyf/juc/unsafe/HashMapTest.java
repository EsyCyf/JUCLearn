package com.icyf.juc.unsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ESy
 * @Date: 2020/7/3 20:21
 */
public class HashMapTest {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>(16,0.75f);
//        Map<String, String> map = new HashMap<>();
//
//        for (int i = 0; i < 20; i++) {
//            new Thread(()->{
//                map.put(Thread.currentThread().getName(),
//                        UUID.randomUUID().toString().substring(0,5));
//                System.out.println(map);
//            },String.valueOf(i)).start();
//            //java.util.ConcurrentModificationException
//
//        }

        Map<String, String> map = new ConcurrentHashMap<>();
        final Lock lock = new ReentrantLock();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                lock.lock();

                try {
                    map.put(Thread.currentThread().getName(),
                            UUID.randomUUID().toString().substring(0,5));
                    System.out.println(map);
                } finally {
                    lock.unlock();
                }

            },String.valueOf(i)).start();
        }

    }
}
