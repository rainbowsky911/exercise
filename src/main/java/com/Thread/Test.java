package com.Thread;

import javafx.concurrent.Task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        MyTask objectTask = new MyTask();
        Future<?> result  = executorService.submit(objectTask);
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("主线程执行任务");

        try {
            System.out.println("task运行结果"+result.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }
}

/**
 * dd
 */
class  MyTask implements Callable{

    @Override
    public Object call() throws Exception {

        System.out.println("子线程正在计算");
        Thread.sleep(3000);
        int sum=0;
        for (int i = 0; i < 100; i++) {
            sum+=i;
        }
        return sum;

    }
}
