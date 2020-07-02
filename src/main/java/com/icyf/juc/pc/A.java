package com.icyf.juc.pc;

/**
 * @Author: ESy
 * @Date: 2020/7/2 19:22
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0;i<5;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A01").start();

        new Thread(()->{
            for (int i = 0;i<5;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A02").start();

        new Thread(()->{
            for (int i = 0;i<5;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B01").start();

        new Thread(()->{
            for (int i = 0;i<5;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B02").start();

    }

}

//资源类
class Data{
    private int number = 0;
    public synchronized void increment() throws InterruptedException {
        Thread.sleep(200);
        while (number!=0){
            //等待
            wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"--->"+number);
        //通知
        notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        Thread.sleep(200);
        while (number==0){
            //等待
            wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"--->"+number);
        //通知
        notifyAll();
    }
}
