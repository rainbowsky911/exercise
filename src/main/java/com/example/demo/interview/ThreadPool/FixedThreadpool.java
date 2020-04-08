package com.example.demo.interview.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadpool {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            final  int index=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"\t index"+index);
                    Thread.currentThread().interrupt();

                    if(Thread.currentThread().isInterrupted()){
                        return;
                    }
                    System.out.println("执行了interpurt方法");
                }
            });

            executorService.shutdown();
            System.out.println("isShutdown:"+executorService.isShutdown());
            System.out.println("isTerminated"+executorService.isTerminated());

            while (true){
                if(executorService.isTerminated()){
                    System.out.println("所有子线程都结束了");
                    break;
                }
            }
        }

    }
}
