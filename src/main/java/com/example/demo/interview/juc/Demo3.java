package com.example.demo.interview.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3 {
    public static void main(String[] args) {

        MyService service=new MyService();

        Mythread mythread =new Mythread(service);
        Mythread mythread1 =new Mythread(service);
        Mythread mythread2 =new Mythread(service);
        Mythread mythread3 =new Mythread(service);
        mythread.start();
        mythread1.start();
        mythread2.start();
        mythread3.start();
    }
}

class  MyService {

    private Lock lock  =new ReentrantLock();

    public  void testMethod(){

        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
            }
        }finally {
            lock.unlock();
        }
    }
}

class Mythread extends  Thread{

    private  MyService myService;

    public Mythread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}