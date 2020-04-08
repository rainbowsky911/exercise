package com.example.demo.interview.juc;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseMoreConditionWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        MyServicemoreCondition myServicemoreCondition =new MyServicemoreCondition();

        MythreadAA a =new MythreadAA(myServicemoreCondition);
        a.setName("A");
        a.start();


        MythreadBB b =new MythreadBB(myServicemoreCondition);
        b.setName("B");
        b.start();

        Thread.sleep(3000);
        myServicemoreCondition.singalA();
       // myServicemoreCondition.singalB();

    }





}

class MyServicemoreCondition{

    private Lock lock =new ReentrantLock();
    private Condition conditionA=lock.newCondition() ;

    private  Condition conditionB=lock.newCondition();

    public  void awaitA(){

        lock.lock();
        try {
            System.out.println("A await start time"+System.currentTimeMillis());
           conditionA.await();
            System.out.println("A await end time"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void singalA(){
        lock.lock();
        try {
            System.out.println("A singal  start time"+System.currentTimeMillis());
            conditionA.signalAll();
            System.out.println("A singal  end  time"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public  void awaitB(){
        lock.lock();
        try {
            System.out.println("B await start time"+System.currentTimeMillis());
            conditionB.await();
            System.out.println("B await end time"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void singalB(){
        lock.lock();
        try {
            System.out.println("B singal  start time"+System.currentTimeMillis());
            conditionB.signalAll();
            System.out.println("B singal  end  time"+System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}


@Data
class MythreadAA  extends  Thread{

    private MyServicemoreCondition servicemoreCondition;

    public MythreadAA(MyServicemoreCondition servicemoreCondition) {
        this.servicemoreCondition = servicemoreCondition;
    }

    @Override
    public void run() {
        servicemoreCondition.awaitA();
    }
}

@Data
class MythreadBB  extends  Thread{

    private MyServicemoreCondition servicemoreCondition;

    public MythreadBB(MyServicemoreCondition servicemoreCondition) {
        this.servicemoreCondition = servicemoreCondition;
    }

    @Override
    public void run() {
        servicemoreCondition.awaitB();
    }
}
