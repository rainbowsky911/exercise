package com.example.demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProduceDemo {
    public static void main(String[] args) {

     /*   Aircindition aircindition =new Aircindition();
        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    aircindition.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    aircindition.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    aircindition.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    aircindition.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();*/


        Apple apple =new Apple();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                apple.increase();
            }
        },"apple1").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                apple.decrease();
            }
        },"apple2").start();
    }
}

class Aircindition{
    int num=0;
    public  synchronized void increment() throws InterruptedException {

       while (num!=0){
            this.wait();
        }

        num++;
        System.out.println(Thread.currentThread().getName()+'\t'+num);
        this.notifyAll();
    }
    public  synchronized void decrease() throws InterruptedException {
        while (num == 0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+'\t'+num);
        this.notifyAll();
    }
}

class Apple{
    int num=0;

    Lock lock =new ReentrantLock();
    Condition condition=lock.newCondition();

        public  void  increase(){
            lock.lock();

            try {
                while (num!=0){
                    condition.await();
                }
                num++;
                System.out.println(Thread.currentThread().getName()+'\t'+num);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public  void decrease(){
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