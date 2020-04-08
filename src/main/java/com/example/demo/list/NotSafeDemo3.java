package com.example.demo.list;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NotSafeDemo3 {
    public static void main(String[] args) {

        Map<String,String> map=new ConcurrentHashMap<>();
        for (int i = 0; i < 1303; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,9));
                // list.forEach(System.out::println);
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }
}
