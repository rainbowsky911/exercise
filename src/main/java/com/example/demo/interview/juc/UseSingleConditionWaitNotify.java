package com.example.demo.interview.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseSingleConditionWaitNotify {
    public static void main(String[] args) throws InterruptedException {

            MyServcicee myServcicee =new MyServcicee();
            ThreadtA t1 =new ThreadtA(myServcicee);
            t1.start();

            Thread.sleep(3000);
            myServcicee.singal();


    }
}


class MyServcicee {
    private Lock lock =new ReentrantLock();
    private  Condition condition =lock.newCondition();


    public  void await(){
        lock.lock();
        try {
            System.out.println("这是await之前"+System.currentTimeMillis());
          condition.await();
            System.out.println("这是condition.await()方法之后的语句，condition.signal()方法之后我才被执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  void  singal(){
        lock.lock();
        try {
            System.out.println("signal时间为" + System.currentTimeMillis());
           condition.signalAll();
           Thread.sleep(3000);
            System.out.println("这是condition.signal()方法之后的语句");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

class  ThreadtA extends Thread{
    private  MyServcicee myService;

    public ThreadtA(MyServcicee myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.await();
    }
}