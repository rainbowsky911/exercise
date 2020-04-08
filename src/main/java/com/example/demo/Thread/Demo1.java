package com.example.demo.Thread;

public class Demo1 implements  Runnable {
    @Override
    public void run() {
        int num=0;
        while (true&&!Thread.currentThread().isInterrupted()){
            System.out.println("go");
            throwInterrupt();

        }
        System.out.println("检测到了中断，循环打印退出");
    }

    private void throwInterrupt(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();//重新设置中断
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Thread thread =new Thread(new Demo1());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}
