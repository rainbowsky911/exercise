package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestList {

    @Test
    public void testMap() {
        Map<Object,Object>map =new ConcurrentHashMap<>();
        for (int i = 0; i < 300000; i++) {
            int finalI = i;
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }).start();
        }

    }

    @Test
    public void testSync() {
        List<String> list= new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add("faker");
                list.add("李民国");
            }).start();
        }
        System.out.println(list.toString());
    }

    @Test
    public void testSet() {

            Set set2=Collections.synchronizedSet(new HashSet<>());
           Set set =new CopyOnWriteArraySet();
            for (int i = 0; i < 3000; i++) {
                new Thread(()->{
                 //   set.add("faker");
                    set.add("李民国");
                }).start();
            }
            System.out.println(set.toString());
        }

    @Test
    public void linkedHashSet() {
        LinkedHashSet linkedHashSet=new LinkedHashSet();
        linkedHashSet.add("1");
        linkedHashSet.add("2");
        linkedHashSet.add("3");
        System.out.println(linkedHashSet);
        linkedHashSet.remove("1");
        linkedHashSet.add("1");
        System.out.println(linkedHashSet);

    }
}

