package com.example.demo.interview;

public class PrintDemo {

    public  void printCount(){
        try {
            for (int i = 5; i >0 ; i--) {
                System.out.println("Counter"+i);
            }
        }catch (Exception e){
            System.out.println("thread interrupted");
        }
    }
}

class  ThreadDemo extends  Thread{
    private  Thread thread;
    private  String threadName;
    PrintDemo printDemo;

    public ThreadDemo(String threadName, PrintDemo printDemo) {
        this.threadName = threadName;
        this.printDemo = printDemo;
    }

    @Override
    public void run() {
        synchronized (printDemo){
            printDemo.printCount();
        }
        System.out.println("thread"+threadName+"exiting");
    }

    @Override
    public synchronized void start() {
        System.out.println("starting"+threadName);
        if(thread==null){
            thread=new Thread(this,threadName);
            thread.start();
        }
    }

    public static void main(String[] args) {

        PrintDemo printDemo =new PrintDemo();

        ThreadDemo t1=new ThreadDemo("thread-1",printDemo);
        ThreadDemo t2=new ThreadDemo("thread-2",printDemo);

        t1.start();
        t2.start();

        try {
            //t1.join();
            //t2.join();
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("interrupted");
        }


    }
}
