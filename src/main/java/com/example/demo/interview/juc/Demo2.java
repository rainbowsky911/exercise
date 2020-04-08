package com.example.demo.interview.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * notifyAll 部分唤醒
 */


public class Demo2 {

    private Lock lock =new ReentrantLock();
    private Condition conditionA =lock.newCondition();
    private Condition conditionB =lock.newCondition();

    public  void await(){
        try {
            lock.lock();
            System.out.println("A开始等待"+System.currentTimeMillis());
            conditionA.await();
            System.out.println("A结束等待"+System.currentTimeMillis());

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }


    public  void awaitB(){
        lock.lock();
        try {
            System.out.println("A开始等待"+System.currentTimeMillis());
            conditionA.await();
            System.out.println("A结束等待"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



    public  void notifyAll_(){
           lock.lock();
           conditionA.signalAll();
           lock.unlock();
    }

    public  void notifyAllB(){
        lock.lock();
        conditionB.signalAll();
        lock.unlock();
    }


    public static void main(String[] args) throws InterruptedException {

        Demo2 demo2 = new Demo2();
        new Thread(new Runnable() {
            @Override
            public void run()
            {
                demo2.await();
            }
        }).start();
                    Thread.sleep(2000);
        demo2.notifyAll();
    }
}
