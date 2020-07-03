package com.example.demo.Thread;

import lombok.SneakyThrows;

public class Mythread2 extends  Thread {



    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("停止状态 即将退出");
                    throw new InterruptedException();
                    //break;
                }
                System.out.println("i=" + i + 1);
            }
            System.out.println("看到这句话说明线程并未终止------");
        }catch (InterruptedException e){
            /**
             *  System.out.println("catch interrupted exception");
             *   e.printStackTrace();
             */

            Thread.currentThread().interrupt();//这样处理比较好
        }
    }
}

class  testMythread2{
    public static void main(String[] args) {

     try {
        Mythread2 mythread2 = new Mythread2();
        mythread2.start();
        Thread.sleep(1000);
        mythread2.interrupt();
    }catch (Exception e){
         System.out.println("main catch");
     }
        System.out.println("end");
    }

}