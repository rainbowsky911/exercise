package com.example.demo.juc.jun2;

public class TestWaitNotify {

    public static void main(String[] args) {

        AirCon airCon=new AirCon();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    airCon.add();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"a").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    airCon.sub();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"b").start();
    }



}


class  AirCon{
 private  int  num=10;

 public   synchronized void add() throws InterruptedException {
     while (num!=0){
         this.wait();
     }
     num++;
     System.out.println(Thread.currentThread().getName()+'\t'+num);
     this.notify();
 }

 public   synchronized void sub() throws InterruptedException {
     while (num!=0){
         num--;
         System.out.println(Thread.currentThread().getName()+'\t'+num);
         this.notify();
     }
     this.wait();
 }
}