package com.example.demo.interview;

public class ReentrantTest implements Runnable {
    @Override
    public void run() {
      get();
    }
    public synchronized  void get(){
        System.out.println(Thread.currentThread().getName());
        set();
    }
    public  synchronized void set(){
        System.out.println(Thread.currentThread().getName());
        get();
    }

    public static void main(String[] args) {
        ReentrantTest test=new ReentrantTest();
        for(;;){
            new Thread(test).start();
        }

    }
}
