package com.example.demo.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo3 {

    public static void main(String[] args) {
/*
        List<String> list = new ArrayList<>();
        list.add("武汉加油");
        list.add("中国加油");
        list.add("世界加油");
        list.add("世界加油");

        long count = list.stream().count();
        System.out.println(count);

        Stream<String> stream = list.stream().filter(e -> e.contains("世界"));
        stream.forEach(System.out::print);

        boolean b = list.stream().anyMatch(e -> e.contains("武"));*/



        Integer[] ints = {0, 1, 2, 3};
        Stream<Integer> integerStream = Stream.of(ints);
       // Integer max = integerStream.reduce((a, b) -> a >= b ? a : b).get();
        Integer sum = integerStream.reduce((a, b) -> a + b).get();
        System.out.println("res:"+sum);

        List<Integer> list = Arrays.asList(ints);

        Optional<Integer> optional = list.stream().reduce((a, b) -> a + b);
        Optional<Integer> optional1 = list.stream().reduce(Integer::sum);
        System.out.println(optional.orElse(0));
        System.out.println(optional1.orElse(0));

        int reduce = list.stream().reduce(6, (a, b) -> a + b);
        System.out.println(reduce);
        int reduce1 = list.stream().reduce(6, Integer::sum);
        System.out.println(reduce1);

    }
}
