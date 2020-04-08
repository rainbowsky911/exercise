package com.example.demo.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotSafeDemo {
    public static void main(String[] args) {
        List<String>list =new CopyOnWriteArrayList<>();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,9));
               // list.forEach(System.out::println);
                System.out.println(list);
            },String.valueOf(i)).start();
        }



    }
}
