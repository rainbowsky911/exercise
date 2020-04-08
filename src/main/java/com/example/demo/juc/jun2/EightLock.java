package com.example.demo.juc.jun2;

import java.util.concurrent.TimeUnit;

public class EightLock {
    public static void main(String[] args) throws InterruptedException {
        Pear pear =new Pear();
        Pear pear2 =new Pear();

        new Thread(()->{
            try {
               pear.email();
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
                pear2.message();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

class  Pear{

    public synchronized void email() throws InterruptedException {
       TimeUnit.SECONDS.sleep(2);
        System.out.println("email");
    }
    public   synchronized void message(){
        System.out.println("message");
    }
    public  void sayHello(){
        System.out.println("say hello");
    }
}
