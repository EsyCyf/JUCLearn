package com.icyf.juc.Single;

/**
 * @Author: ESy
 * @Date: 2020/7/4 17:03
 */
public class LazyManSafe {
    //线程安全，但是锁占用资源
    private LazyManSafe(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    private static LazyManSafe instance;

    public synchronized static LazyManSafe getInstance(){
        if (instance==null){
            instance = new LazyManSafe();
        }
        return instance;
    }
}
