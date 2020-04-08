package com.example.demo.stream;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给出数据 找出同时满足一下条件:
 *  偶数ID
 *  年龄大于20
 *  且用户名转为大写
 *  且用户名字字母倒排序
 *
 */

public class StreamDemo2 {


    public static void main(String[] args) {
        Book2 book1 = new Book2(11, "a", 33);
        Book2 book2 = new Book2(12, "b", 77);
        Book2 book3 = new Book2(16, "c", 11);
        Book2 book4 = new Book2(8, "d", 33);
        Book2 book5 = new Book2(25, "e", 27);
        Book2 book6 = new Book2(4, "z", 100);

        List<Book2> list = Arrays.asList(book1, book2, book3, book4, book5, book6);

        List<Book2> collect1 = list.stream().filter(u -> {
            return u.getId() % 2 == 0;
        }).filter(u -> {
            return u.getAge() > 20;
        }).sorted(Comparator.comparing(Book2::getId)).collect(Collectors.toList());

        /*.map(m -> {
            return "id" + m.getId() + "," + "name:" + m.getName().toUpperCase() + "age" + m.getAge();*/


        collect1.stream().forEach(System.out::println);
        System.out.println("------------");


        /* Stream<Book2> book2Stream =*/
        List<Book2> collect = list.stream().filter(u -> {
            return (u.getId() % 2 == 0);
        }).filter(u -> {
            return u.getAge() > 20;
        })/*.map( m->{
         return "id:"+m.getId()+",  "+"name:"+m.getName().toUpperCase()+",  "+"age:"+m.getAge(); *//*m.getName()*//*
      })*/.sorted(Comparator.comparing(Book2::getAge).reversed()).collect(Collectors.toList());


      collect.stream().map(m->{
        return "id:"+m.getId()+",  "+"name:"+m.getName().toUpperCase()+",  "+"age:"+m.getAge();
      }).forEach(System.out::println);


        List<Integer> integers = Arrays.asList(1, 2, 3);
        Stream<Integer> integerStream = integers.stream().map(x -> {
            return x + 1;
        });


        System.out.println(integerStream.collect((Collectors.toList())));



       // System.out.println(book2Stream.collect(Collectors.toList()));
    }
}

@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
class Book2 implements Comparable<Book2> {

    private int id;
    private String name;
    private int age;


    @Override
    public int compareTo(Book2 book) {

        int tmp =  this.getAge() - book.getAge();
        if (tmp == 0) {
            return this.getId()-book.getId();
        }
        return tmp;
    }
}