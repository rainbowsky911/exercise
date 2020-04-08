package com.example.demo.juc.jun2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestlockDemo {
    public static void main(String[] args) {


        Lemon lemon =new Lemon();
        new Thread(()->{

            for (int i = 0; i < 5; i++) {
                lemon.add();
            }
        },"produce").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                lemon.sub();
            }

        },"consume").start();
    }
}


class Lemon{
    private  int num=0;
    Lock lock =new ReentrantLock();
    Condition condition =lock.newCondition();

    public  void add(){
        lock.lock();
        try {
            while (num!=0){
                condition.await();

            }
            condition.signalAll();
            num++;
            System.out.println(Thread.currentThread().getName()+'\t'+num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public  void sub(){
        lock.lock();
        try {
        while (num!=0){
            num--;
            System.out.println(Thread.currentThread().getName()+'\t'+num);
            condition.signalAll();
        }
        condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}