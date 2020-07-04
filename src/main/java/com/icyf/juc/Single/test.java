package com.icyf.juc.Single;

/**
 * @Author: ESy
 * @Date: 2020/7/4 16:47
 */
public class test {
    public static void main(String[] args) {
        LazyMan instance1 = LazyMan.getInstance();
        LazyMan instance2 = LazyMan.getInstance();


        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance1==instance2);
    }

}
