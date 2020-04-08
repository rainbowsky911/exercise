package com.example.demo.interview;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapdemo2 {

    public static void main(String[] args) throws InterruptedException {

        Map<Long,String> map=new ConcurrentHashMap<>();
        for (long i = 0; i < 5; i++) {
            map.put(i,i+"");
        }
        
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                map.put((long) 100L,"1001");
                System.out.println("ADD"+100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (Map.Entry<Long,String> entry:map.entrySet()) {
                    long key =entry.getKey();

                    System.out.println(entry.getKey()+"--"+entry.getValue());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        
        thread.start();
        thread1.start();
        Thread.sleep(3000);

        System.out.println("--------");
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
