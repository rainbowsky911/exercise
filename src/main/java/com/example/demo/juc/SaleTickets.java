package com.example.demo.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTickets {
    public static void main(String[] args) {
        Tickets tickets =new Tickets();

        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                    tickets.sale();
                }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                    tickets.sale();
                }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                    tickets.sale();
                }
        },"C").start();

    }
}

class  Tickets{
    private  int num=50;
    Lock lock =new ReentrantLock();

    public  void  sale(){
        lock.lock();
        try {
            if(num>0){
                System.out.println(Thread.currentThread().getName()+"正在卖"+(num--)+"还剩下"+num+"张票");

            }
        }finally {

            lock.unlock();
        }
    }
}