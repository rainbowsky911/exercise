package com.example.demo.interview;

import java.util.concurrent.atomic.AtomicReference;

public class UnreentLock {

    private AtomicReference<Thread> owner=new AtomicReference<>();

    public  void lock(){
        Thread cureent =Thread.currentThread();
        for(;;){
            if(!owner.compareAndSet(null,cureent)){
                return;
            }
        }
    }
    public  void unlock(){
        Thread current=Thread.currentThread();
        owner.compareAndSet(current,null);
    }
}
