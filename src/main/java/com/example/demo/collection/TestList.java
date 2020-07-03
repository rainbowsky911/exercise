package com.example.demo.collection;

import java.util.*;
import java.util.stream.Collectors;

public class TestList {
    private static List<String> list3;
    public static void main(String[] args) {


        list3 = new ArrayList<String>(
                Arrays.asList("tom","com","boss","boss","jerry","jerry"));

        Set set =new LinkedHashSet();
        set.addAll(list3);
        set.stream().forEach(System.out::println);

        list3.stream().distinct().forEach(System.out::println);

    }
}
