package com.icyf.juc.Single;

/**
 * @Author: ESy
 * @Date: 2020/7/4 17:14
 */
//静态内部类
public class Holder {
    private Holder(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    static class InnerHolder{
        private static final Holder instance = new Holder();
    }

    public static Holder getInstance(){
        return InnerHolder.instance;
    }

}
