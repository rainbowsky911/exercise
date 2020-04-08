package com.example.demo.juc.reentranlock;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    static Lock lock =new ReentrantLock(true);

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadDemo(i)).start();
        }
    }

    @AllArgsConstructor
    static class  ThreadDemo implements  Runnable{

        Integer id;

        @Override
        public void run() {
            try {
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 3; i++) {
                lock.lock();
                System.out.println("获得锁的线程"+id);
                lock.unlock();
            }
        }
    }
}
