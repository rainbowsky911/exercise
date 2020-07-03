package com.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutrureTaskDemo
{

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future result1 =executorService.submit(() ->{
            for (int i = 0; i < 200; i++)
                System.out.println("任务1异步执行"+i);
                return "任务1";
        });

        Future result2 =executorService.submit(() ->{
            for (int i = 0; i < 200; i++)
                System.out.println("任务2异步执行"+i);
            return "任务2";
        });
        System.out.println("同步代码");



        try {
            System.out.println(result1.get()+"执行完成");
            System.out.println(result2.get()+"执行完成");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }
}
