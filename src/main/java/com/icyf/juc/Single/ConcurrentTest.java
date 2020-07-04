package com.icyf.juc.Single;

/**
 * @Author: ESy
 * @Date: 2020/7/4 16:55
 */
public class ConcurrentTest {
    public static void main(String[] args) {

        for (int i = 0; i < 40; i++) {
            new Thread(()->{
//                LazyMan instance = LazyMan.getInstance();
//                LazyManSafe instance = LazyManSafe.getInstance();
                DoubleCheck instance = DoubleCheck.getInstance();
//                HungryMan.getInstance();
                System.out.println(instance);
            }).start();
        }

    }
}
