package com.example.demo.hashmap;

import java.util.HashMap;

public class HashMapTest {


    public static void main(String[] args) {

        HashMap<String,String> hashMap =new HashMap<>();

        hashMap.put("1","2");
        String value=hashMap.put("1","3");
        System.out.println(value);

        System.out.println(hashMap.get("2"));
        System.out.println("hhe".hashCode());

        System.out.println(2/4);
    }
}
