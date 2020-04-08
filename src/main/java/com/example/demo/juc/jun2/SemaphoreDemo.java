package com.example.demo.juc.jun2;

import java.sql.Time;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 争车位    信号量
 *
 */
public class SemaphoreDemo {


    public static void main(String[] args) {
        //模拟爱 资源类  有3个车位
        Semaphore semaphore =new Semaphore(1);
        for (int i = 0; i < 5; i++) {
         new Thread(()->{
             try {
                 semaphore.acquire();
                 System.out.println(Thread.currentThread().getName()+"抢占到了车位");
                 TimeUnit.SECONDS.sleep(2);
                 semaphore.release();
                 System.out.println(Thread.currentThread().getName()+"释放了车位");

             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         },String.valueOf(i)) .start();
        }
    }
}
