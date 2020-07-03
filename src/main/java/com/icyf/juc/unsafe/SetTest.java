package com.icyf.juc.unsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ESy
 * @Date: 2020/7/3 20:01
 */
public class SetTest {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//
//        for (int i = 0; i < 20; i++) {
//            new Thread(()->{
//                set.add(UUID.randomUUID().toString().substring(0,5));
//                System.out.println(set);
//            },String.valueOf(i)).start();
//        }
        //Exception in thread "14" java.util.ConcurrentModificationException

        Set<String> set = new CopyOnWriteArraySet<>();

        final Lock lock = new ReentrantLock();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                lock.lock();

                try {
                    set.add(UUID.randomUUID().toString().substring(0,5));
                    System.out.println(set);
                } finally {
                    lock.unlock();
                }

            },String.valueOf(i)).start();
        }

//        HashSet<String> set = new HashSet<>();
//
//        for (int i = 0; i < 10; i++) {
//            set.add(UUID.randomUUID().toString().substring(0,5));
//            System.out.println(set);
//        }


    }
}
