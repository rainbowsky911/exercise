package com.example.demo.interview.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock  extends  Thread{

    public  static ReentrantLock lock =new ReentrantLock();

    public TryLock(String name){
        super(name);
    }

    @Override
    public void run() {
        try{
            if (lock.tryLock(5, TimeUnit.SECONDS)){
                    Thread.sleep(3000);
            }else {
                System.out.println(this.getName()+"this.get lock faild");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(lock.isHeldByCurrentThread()){
                System.out.println("lock isHeldBycurrentThread"+this.getName());
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {

        TryLock tryLock =new TryLock("trylock1");
        TryLock tryLock2 =new TryLock("trylock2");

        tryLock.start();
        tryLock2.start();

    }
}
