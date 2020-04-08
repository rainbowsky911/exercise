package com.example.demo.juc.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {
    public static void main(String[] args) {


        //一池子5个工作线程 类似一个银行5个工作窗口
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        //一池N个工作线程  类似一个银行N个受理窗口
       // ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //一池N个工作线程  类似一个银行N个受理窗口
       // ExecutorService threadPool=Executors.newCachedThreadPool();

        try{
            for (int i = 0; i < 100; i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"办理业务");
            });
            }
        }finally {
                threadPool.shutdown();
        }

    }
}
