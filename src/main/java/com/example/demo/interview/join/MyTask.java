package com.example.demo.interview.join;

public class MyTask implements  Runnable {

    private int  taskNum;
    private Thread thread=null;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    public MyTask(int taskNum, Thread thread) {
        this.taskNum = taskNum;
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println("正在执行"+taskNum);
        try{
            if(thread!=null){
                System.out.println("join线程开始执行");
                thread.start();
                thread.join();
                System.out.println("join执行完毕");
                System.out.println("继续执行当前线程");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task"+taskNum+"执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread t2=new Thread(new MyTask(10));
        Thread t1=new Thread(new MyTask(5,t2));
                t1.start();
                t1.join();
        System.out.println(Thread.currentThread().getName()+"执行完毕");

    }
}
