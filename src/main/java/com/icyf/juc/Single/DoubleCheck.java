package com.icyf.juc.Single;

/**
 * @Author: ESy
 * @Date: 2020/7/4 17:06
 */
public class DoubleCheck {

    private DoubleCheck(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    //解决原子性问题
    private volatile static DoubleCheck instance;

    public static DoubleCheck getInstance(){
        if (instance==null){
            synchronized (DoubleCheck.class){
                if (instance==null){
                    instance = new DoubleCheck();
                }
            }
        }

        return instance;
    }
}
