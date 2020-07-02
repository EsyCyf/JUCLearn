package com.icyf.juc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: ESy
 * @Date: 2020/7/2 23:04
 */
public class ListTest {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();

//        for (int i=0;i<=20;i++){
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,4));
//                System.out.println(list);
//            },String.valueOf(i)).start();
//            //Exception in thread "14" java.util.ConcurrentModificationException
//            //当不允许这样的修改时，可以通过检测到对象的并发修改的方法来抛出此异常。
//        }

        /*
        * 1、List<String> list = new Vector<>();
        *
        * 2、List<String> list = Collections.synchronizedList(new ArrayList<>());
        * 写入时复制
        * 3、List<String> list = new CopyOnWriteArrayList<>();
        * */


        List<String> list = new CopyOnWriteArrayList<>();
        for (int i=0;i<=20;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,4));
                System.out.println(list);
            },String.valueOf(i)).start();

        }



    }
}
