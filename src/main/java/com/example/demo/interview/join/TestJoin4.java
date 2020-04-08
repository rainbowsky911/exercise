package com.example.demo.interview.join;

public class TestJoin4  extends Thread{
    private  Thread thread;
    public TestJoin4(Thread pre) {
        this.thread=pre;
    }

    @Override
    public void run() {
      try{
          thread.join();
          System.out.println(thread.getName()+"terminated");
      } catch (Exception e) {

      }
    }

    public static void main(String[] args) {

        Thread pre=Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread curthread=new TestJoin4(pre);
            curthread.start();
            pre=curthread;
        }


    }
}
