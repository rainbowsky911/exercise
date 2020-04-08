package com.example.demo.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {

    public static void main(String[] args) {

        Mythread_test mythread_test = new Mythread_test();

        FutureTask<Integer> futureTask = new FutureTask<>(mythread_test);

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+""+i);
            if(i==30){
                Thread thread =new Thread(futureTask);
                thread.start();
            }
        }
        System.out.println("主线程for循环执行完毕");

        try {
            int sum=futureTask.get();
            System.out.println("sum="+sum);
        }catch (Exception e){

        }finally {


        }

    }
}


class  Mythread_test implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {

       Integer sum=0;
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+""+i);
            sum+=i;
        }
        return sum;
    }
}

