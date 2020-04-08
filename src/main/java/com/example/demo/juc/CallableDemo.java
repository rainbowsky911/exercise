package com.example.demo.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask =new FutureTask(new Mythread());

      new Thread(futureTask,"A").start();
      new Thread(futureTask,"B").start();

        System.out.println(Thread.currentThread().getName()+"计算完成");

        System.out.println(futureTask.get());

    }
}

class Mythread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("come int call");

        TimeUnit.SECONDS.sleep(3);
        return 1024;
    }
}