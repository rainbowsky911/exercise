package com.example.demo.juc.jun2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * 做加法
 */
public class CycliBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier =new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集到第"+ finalI +"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
