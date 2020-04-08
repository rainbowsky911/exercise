package com.example.demo.interview;

public class DeadLockDemo
{
    private static  Object resuouce1=new Object();
    private static  Object resuouce2=new Object();

    public static void main(String[] args) {

        new Thread(()->{
            synchronized (resuouce1) {
                System.out.println(Thread.currentThread().getName() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resuouce2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        },"线程1").start();

        new  Thread(()->{
           synchronized (resuouce1){
               System.out.println(Thread.currentThread()+"get resouce2");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread()+"waiting get resource1");
               synchronized (resuouce2){
                   System.out.println(Thread.currentThread()+"get resouce1");
               }
           }
        },"线程2").start();

    }



}
