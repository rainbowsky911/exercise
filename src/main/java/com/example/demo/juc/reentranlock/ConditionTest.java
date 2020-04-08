package com.example.demo.juc.reentranlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {


    public static void main(String[] args) {
        Apple apple =new Apple();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    try {
                        apple.add();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    try {
                        apple.sub();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }



}

class Apple{
    static ReentrantLock lock =new ReentrantLock();
    static Condition condition=lock.newCondition();

    private  int count =0;

    public  void add() throws InterruptedException {
        lock.lock();
        try {
            while (count!=0){
                condition.await();
            }

            condition.signalAll();
            count++;
            System.out.println(Thread.currentThread().getName()+'\t'+count);
        }catch (Exception e){

        }finally {
            lock.unlock();
        }



    }
    public  void sub() throws InterruptedException {
        lock.lock();

        try {
            while (count!=0){
                  count--;
                System.out.println(Thread.currentThread().getName()+'\t'+count);
                condition.signalAll();
        }
                condition.await();

        }catch (Exception e){

        }finally {
            lock.unlock();
        }


    }
}