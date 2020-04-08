package com.example.demo.juc;

import java.util.concurrent.TimeUnit;

public class LockDmeo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone =new Phone();
        Phone phone2 =new Phone();
        new Thread(()->{
            try {
                phone.email();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(100);
        new Thread(()->{
            try {
              //  phone.message();
                //phone.sayHello();
               // phone2.message();
                phone2.message();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

class Phone {
    public static synchronized void email() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
         System.out.println("email");
    }
    public   synchronized  void message(){
        System.out.println("message");
    }
    public  void sayHello(){
        System.out.println("say hello");
    }
}