package com.example.demo.juc.ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(
                2,
                13,
                2L, //保留时间
                TimeUnit.SECONDS,   //时间单位
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),   //线程工厂
                new ThreadPoolExecutor.DiscardPolicy()  //拒绝策略
        );
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <=9; i++) {
                threadPool.execute( ()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        }finally {
            threadPool.shutdown();
        }
    }
}
