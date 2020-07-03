package com.example.demo.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class TestMapSort {
    public static void main(String[] args) {

        Map<String, User> map = new HashMap<>();
        map.put("1", new User("zhangsan", 17));
        map.put("2", new User("lisi", 10));
        map.put("3", new User("wangwu", 20));
        map.put("4", new User("zhaoliu", 19));
        // 排序前
        map.forEach((key, value) -> System.out.println("key: " + key + ", value:" + value));

        System.out.println("=================");
        map = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparingInt(User::getAge)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        // 排序后
        map.forEach((key, value) -> System.out.println("key: " + key + ", value:" + value));


        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(77);
        list.add(-1);
        list.add(11);
        list.stream().sorted().forEach(System.out::println);
    }

}

@AllArgsConstructor
@NoArgsConstructor
@ToString

@Data
class User{
    private String name;
    private int age;
}

