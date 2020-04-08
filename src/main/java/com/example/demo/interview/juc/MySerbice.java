package com.example.demo.interview.juc;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

@Data
public class MySerbice implements  Runnable {

 private  static ReentrantLock  lock=new   ReentrantLock();
    public static void main(String[] args) {
                    new Thread(new MySerbice()).start();
                    new Thread(new MySerbice()).start();
    }
        private  void method(){
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"锁定");

                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName()+" 解锁。");

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }


        }




    @Override
    public void run() {
        method();
    }
}



