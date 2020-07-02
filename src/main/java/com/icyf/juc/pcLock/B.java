package com.icyf.juc.pcLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ESy
 * @Date: 2020/7/2 20:03
 * 精准通知和唤醒
 */
public class B {
    public static void main(String[] args) {
        DataB dataB = new DataB();
        new Thread(()->{
            for (int i = 0;i<10;i++){
                dataB.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0;i<10;i++){
                dataB.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0;i<10;i++){
                dataB.printC();
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0;i<10;i++){
                dataB.printA();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0;i<10;i++){
                dataB.printB();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0;i<10;i++){
                dataB.printC();
            }
        },"CC").start();

    }
}

class DataB{
    private final Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    private int number = 1;


    public void printA(){
        lock.lock();
        try{
            while (number%3!=0){
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+number);
            number++;
            //精准唤醒
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try{
            while (number%3!=1){
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+number);
            number++;
            //精准唤醒
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try{
            while (number%3!=2){
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+number);
            number++;
            //精准唤醒
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
