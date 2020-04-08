package com.example.demo.interview.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final  int index=i;
            try {
                Thread.sleep(index*1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index+"当前线程"+Thread.currentThread().getName());
                }
            });

        }



    }
}
