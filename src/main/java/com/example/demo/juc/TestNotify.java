package com.example.demo.juc;

public class TestNotify {
    public static void main(String[] args) {

        Runnable runnable =()->{
          synchronized ("A") {
              System.out.println("A线程持有了A锁 等待B锁");

              try {
                  "A".wait();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              ;
              synchronized ("B") {
                  System.out.println("A线程同时持有了A锁和B锁");
              }
          }
        };

        Runnable runnable2 =()->{
            synchronized ("B"){
                System.out.println("B线程持有了B锁 等待A锁");

            synchronized ("A") {
                System.out.println("B线程同时持有了B锁和A锁");
                "A".notifyAll();
            }
            }
        };

        Thread t =new Thread(runnable);
        Thread t2 =new Thread(runnable2);
        t.start();
        t2.start();
    }


}
