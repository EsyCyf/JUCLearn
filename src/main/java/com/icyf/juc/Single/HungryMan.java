package com.icyf.juc.Single;

/**
 * @Author: ESy
 * @Date: 2020/7/4 16:47
 */
public class HungryMan {
    //线程安全，但是浪费资源空间
    private HungryMan(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    //注意加上final
    private static final HungryMan instance = new HungryMan();

    public static HungryMan getInstance(){
            return instance;
    }
}
