package com.icyf.juc.Demo01;

/**
 * @Author: ESy
 * @Date: 2020/7/2 17:20
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();


        new Thread(()->{
            SaleTicketDemo01.useSale(ticket);
        },"线程1").start();
        new Thread(()->{
            SaleTicketDemo01.useSale(ticket);
        },"线程2").start();
        new Thread(()->{
            SaleTicketDemo01.useSale(ticket);
        },"线程3").start();


    }
    static void useSale(Ticket ticket){
        for (int i = 50 ; i>0 ; i--){
            ticket.sale();
        }

    }
}

class Ticket{
    private int number = 50 ;

    public synchronized void sale (){
        number--;
        if (number>=0){
            System.out.println(Thread.currentThread().getName()+"卖出了"+(50-number)+"张票,剩余"+number+"张票");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("票卖光了");

        }

    }

}

