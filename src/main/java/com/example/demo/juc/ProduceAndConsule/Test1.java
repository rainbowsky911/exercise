package com.example.demo.juc.ProduceAndConsule;

import java.util.concurrent.locks.Lock;

public class Test1 {
        private  static  int count =0;
        private static  final  int FULL=10;
    private static String LOCK = "lock";
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        new Thread(test1.new Produce()).start();
        new Thread(test1.new Consume()).start();
    }

    class Produce implements  Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count==FULL){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者生产,目前还有"+count );
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consume implements  Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count==0){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费者消费,目前还有"+count );
                    LOCK.notifyAll();
                }
            }
        }
    }

}

