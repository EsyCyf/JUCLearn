package com.icyf.juc.Demo02;

import com.icyf.juc.Demo02.SaleTicketDemo02;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ESy
 * @Date: 2020/7/2 17:20
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();


        new Thread(() -> {
            SaleTicketDemo02.useSale(ticket);
        }, "线程1").start();
        new Thread(() -> {
            SaleTicketDemo02.useSale(ticket);
        }, "线程2").start();
        new Thread(() -> {
            SaleTicketDemo02.useSale(ticket);
        }, "线程3").start();


    }

    static void useSale(Ticket ticket) {
        for (int i = 50; i > 0; i--) {
            ticket.sale();
        }

    }
}

class Ticket {
    private int number = 50;
    Lock lock = new ReentrantLock();


    public void sale() {
        lock.lock();
        try {
            number--;
            if (number >= 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (50 - number) + "张票,剩余" + number + "张票");

                Thread.sleep(500);

            } else {
                System.out.println(Thread.currentThread().getName()+"票卖光了");

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}

