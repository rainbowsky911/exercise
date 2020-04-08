package com.example.demo.juc.jun2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo2 {
    public static void main(String[] args) {
            ABC_Condition alternate=new ABC_Condition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++){
                    alternate.printA(i);
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++){
                    alternate.printB(i);
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++){
                    alternate.printC(i);
                }
            }
        },"C").start();
    }
}
  class ABC_Condition {
      private int number = 1;

      private Lock lock = new ReentrantLock();//锁

      private Condition condition1 = lock.newCondition();
      private Condition condition2 = lock.newCondition();
      private Condition condition3 = lock.newCondition();


      public void printA(int totalLoop) {

          lock.lock();//加锁

          try {
              while (number != 1) {
                  condition1.await();
              }
              System.out.println(Thread.currentThread().getName() + " == \tA\t" + "第" + totalLoop + "次循环");

              number = 2;
              condition2.signal();//唤醒2
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              lock.unlock();//释放锁
          }

      }

      public void printB(int totalLoop) {

          lock.lock();//加锁

          try {
              while (number != 2) {
                  condition2.await();
              }
              System.out.println(Thread.currentThread().getName() + " == \tB\t" + "第" + totalLoop + "次循环");

              number = 3;
              condition3.signal();//唤醒3
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              lock.unlock();//释放锁
          }

      }

      public void printC(int totalLoop) {

          lock.lock();//加锁

          try {
              while (number != 3) {
                  condition3.await();
              }
              System.out.println(Thread.currentThread().getName() + " == \tC\t" + "第" + totalLoop + "次循环");

              number = 1;
              condition1.signal();//唤醒1
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              lock.unlock();//释放锁
          }

      }


  }