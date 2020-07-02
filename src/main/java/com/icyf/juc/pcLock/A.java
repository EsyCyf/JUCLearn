package com.icyf.juc.pcLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ESy
 * @Date: 2020/7/2 19:22
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0;i<10;i++){
                data.increment();
            }
        },"incrementAAAA").start();

        new Thread(()->{
            for (int i = 0;i<10;i++){
                data.increment();
            }
        },"incrementBBB").start();

        new Thread(()->{
            for (int i = 0;i<10;i++){
                data.decrement();
            }
        },"decrementCCC").start();

        new Thread(()->{
            for (int i = 0;i<10;i++){
                data.decrement();
            }
        },"decrementDDD").start();


    }

}

//资源类
class Data{
    private int number = 0;
    final Lock lock = new ReentrantLock();
    Condition condition =lock.newCondition();

    public  void increment() {
        lock.lock(); try {
            while (number!=0){
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"--->"+number);
            //通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public  void decrement() {
        lock.lock();
        try{
            while (number==0){
                //等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"--->"+number);
            //通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}
