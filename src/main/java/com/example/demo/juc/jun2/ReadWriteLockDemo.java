package com.example.demo.juc.jun2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        Mycache mycache =new Mycache();

        for (int i = 0; i < 5; i++) {
            final  int tmpInt=i;
            new Thread(()->{
                try {
                    mycache.put(tmpInt+"",tmpInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final  int tmpInt=i;
            new Thread(()->{
                try {
                    mycache.get(tmpInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }

}



class  Mycache{

    private  volatile Map<String,Object> map =new HashMap<>();
    private ReadWriteLock lock =new ReentrantReadWriteLock();

    public  void put(String key,Object val) throws InterruptedException {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"\t写入数据"+key);
        TimeUnit.MICROSECONDS.sleep(300);
        map.put(key,val);
        System.out.println(Thread.currentThread().getName()+"\t写入完成");
        lock.writeLock().unlock();
    }
    public  void get(String key) throws InterruptedException {

        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"\t读取数据");
        TimeUnit.MICROSECONDS.sleep(300);

        Object result=map.get(key);
        System.out.println(Thread.currentThread().getName()+"\t读取完成"+result);
        lock.readLock().unlock();
    }
}