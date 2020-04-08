package com.example.demo.interview;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo
{
    public static void main(String[] args) {

        Set<Student> set = new HashSet<>();
        Student student1 = new Student(1001,"young");
        Student student2 = new Student(1001,"young");
        set.add(student1);
        set.add(student2);

        set.forEach(Student -> System.out.println(Student));


    }

}
