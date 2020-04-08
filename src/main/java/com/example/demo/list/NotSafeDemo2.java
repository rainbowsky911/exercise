package com.example.demo.list;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class NotSafeDemo2 {

    public static void main(String[] args) {

        Set<String> set=new HashSet<>();

        for (int i = 0; i < 1303; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,9));
                // list.forEach(System.out::println);
                System.out.println(set);
            },String.valueOf(i)).start();
        }

    }
}
