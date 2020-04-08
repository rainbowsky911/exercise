package com.example.demo.interview;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockDemo1
implements  Runnable{
    public  static ReentrantLock lock =new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {

            lock.lock();
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

      ReenterLockDemo1 demo1 =new ReenterLockDemo1();
      Thread t1 =new Thread(demo1);
      Thread t2 =new Thread(demo1);

      t1.start();
      t2.start();

      t1.join();
      t2.join();


    }
}
