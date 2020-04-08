package com.example.demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 精准控制
 *
 */
public class ConditionDemo {
    public static void main(String[] args) {
            ShareData shareData=new ShareData();
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    try {
                        shareData.printA();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"A").start();
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    shareData.printB();
                }
            },"B").start();
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    shareData.printC();
                }
            },"C").start();

    }
}


class ShareData{
    Lock lock =new ReentrantLock();
    Condition conditionA=lock.newCondition();
    Condition conditionB=lock.newCondition();
    Condition conditionC=lock.newCondition();

    //标志位
    private  int num=1;
    public  void printA() throws InterruptedException {
       lock.lock();
        try {
            while (num!=1){
                conditionA.await();
            }
            //通知
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+'\t'+i);
            }
            num=2;
            conditionA.signal();
        }finally {
            lock.unlock();
        }

    }
    public  void printB(){
        lock.lock();
        try {
            while (num!=2){
                conditionB.await();
            }
            //通知
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+'\t'+i);
            }
            num=3;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  void printC(){
        lock.lock();
        try {
            while (num!=3){
                conditionC.await();
            }
            //通知

            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+'\t'+i);
            }
            num=1;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
