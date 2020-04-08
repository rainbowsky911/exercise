package com.example.demo.interview.ThreadPool;

public class ExecutorTest  implements  Runnable{
    private  Thread t;
    private  String thread;


    public ExecutorTest(String thread) {
        this.thread = thread;
        System.out.println("creating "+thread);
    }

    @Override
    public void run() {
        System.out.println("Running "+thread);
        try {
            for (int i = 4; i >0 ; i--) {
                System.out.println("Thread:"+thread+","+i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread:"+thread+"interupted");
        }
        System.out.println("thread"+thread+"exiting");
    }
    public void start () {
        System.out.println("Starting " +  thread);
        if (t == null) {
            t = new Thread (this, thread);
            t.start ();
        }
    }

    public static void main(String[] args) {
        
        ExecutorTest e1 =new ExecutorTest("thread1");
        ExecutorTest e2 =new ExecutorTest("thread2");

        e1.start();
        e2.start();


    }


}
