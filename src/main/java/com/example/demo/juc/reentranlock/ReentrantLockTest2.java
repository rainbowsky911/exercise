package com.example.demo.juc.reentranlock;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest2 {
        static  Lock lock1 =new ReentrantLock();
        static  Lock lock2 =new ReentrantLock();

    public static void main(String[] args) {
        Thread thread=new Thread(new ThreadDemo(lock1,lock2));
        Thread thread2=new Thread(new ThreadDemo(lock2,lock1));

        thread.start();
        thread2.start();
        thread2.interrupt();
    }

}

@AllArgsConstructor
class  ThreadDemo implements  Runnable{
    Lock firstLock;
    Lock secondLock;


    @Override
    public void run() {
        try {

            /***
             *
             * 中断
             */
           /* firstLock.lockInterruptibly();
            TimeUnit.MICROSECONDS.sleep(10);
            secondLock.lockInterruptibly();*/

            /***
             *
             * 限时等待
             */
            while (!firstLock.tryLock()){
                TimeUnit.MICROSECONDS.sleep(10);
            }
            while ((!secondLock.tryLock())){
                TimeUnit.MICROSECONDS.sleep(10);
            }

        }catch (Exception e){

        }finally {
            firstLock.unlock();
            secondLock.unlock();
            System.out.println(Thread.currentThread().getName()+"正常结束");
        }
    }
}