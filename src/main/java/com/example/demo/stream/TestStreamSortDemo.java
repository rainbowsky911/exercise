package com.example.demo.stream;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class TestStreamSortDemo {

    public static void main(String[] args) {
        List<Student> list = Collections.synchronizedList(new ArrayList<>());

        Student s1 = new Student("zhangsan","beijing",30);
        list.add(s1);

        Student s2 = new Student("lisi","shanghai",29);
        list.add(s2);

        Student s3 = new Student("lining","shandong",31);
        list.add(s3);

        // forEach循环
        list.stream().forEach(student -> System.out.println(student.getAge()));

        List<Student> collect = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());

        System.out.println(collect);


    }
}

@Data
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
class Student{

    private  String name;
    private String address;
    private  int age;
}