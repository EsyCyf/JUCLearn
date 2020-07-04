package com.icyf.juc.Single;

/**
 * @Author: ESy
 * @Date: 2020/7/4 16:51
 */
public class LazyMan {
    //线程不安全
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    private static LazyMan instance;

    public static LazyMan getInstance(){
        if (instance==null){
            instance = new LazyMan();
        }
        return instance;
    }
}
