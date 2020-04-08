package com.example.demo.juc.jun2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccurateLockDemo {
    public static void main(String[] args) {

        HeroList h=new HeroList();
        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                try {
                    h.printMasterYi();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"a").start();
        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                try {
                    h.printTimo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b").start();
        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                try {
                    h.printTwitch();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"c").start();

    }
}

class HeroList{

    private  int status=1;
    Lock lock =new ReentrantLock();
    Condition condition1 =lock.newCondition();
    Condition condition2 =lock.newCondition();
    Condition condition3 =lock.newCondition();

    public  void printMasterYi() throws InterruptedException {
       lock.lock();
       try {

           while (status==1){

               for (int i = 0; i < 3; i++) {
                   System.out.println("master yi");
               }
               status=2;
               condition1.signalAll();
           }
           condition1.await();
       }finally {
           lock.unlock();
       }
    }
    public  void printTimo() throws InterruptedException {
      lock.lock();
      try {
          while (status==2){

              for (int i = 0; i < 3; i++) {
                  System.out.println("Timo");
              }
              status=3;
              condition2.signalAll();
          }
          condition2.await();
      }finally {
          lock.unlock();
      }
    }
    public  void printTwitch() throws InterruptedException {

        lock.lock();

        try {

            while (status==3){

                for (int i = 0; i < 3; i++) {
                    System.out.println("Twitch");
                }
                status=1;
                condition3.signalAll();
            }
            condition3.await();
        }finally {
            lock.unlock();
        }
    }

}