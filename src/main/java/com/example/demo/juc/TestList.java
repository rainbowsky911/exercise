package com.example.demo.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestList {
    public static void main(String[] args) {

        List<String> list= new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add("faker");
                list.add("李民国");
            }).start();
        }
        System.out.println(list.toString());
    }
}
