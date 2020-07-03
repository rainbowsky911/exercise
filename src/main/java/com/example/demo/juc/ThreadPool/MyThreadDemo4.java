package com.example.demo.juc.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadDemo4 {
    public static void main(String[] args) {

        /**
         * 一池子受理五个线程    newFixedThreadPool(5)       类似一个银行5个受理窗口
         * 一池子一个线程  newSingleThreadExecutor           类似一个银行一个受理窗口
         * 一池子N个线程  newCachedThreadPool()               类似一个银行N个受理窗口
         */
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute( ()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        }finally {
            executorService.shutdown();
        }

    }

}
