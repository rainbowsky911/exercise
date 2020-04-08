package com.example.demo.juc.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MythreadDemo2 {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPool2 = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try{
            for (int i = 1; i <=10; i++) {
                threadPool2.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
            }
        }finally {
            threadPool2.shutdown();
        }

    }
        public  static  void initPool(){

        }

}
