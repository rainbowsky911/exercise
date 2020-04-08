package com.example.demo.interview;

import javafx.scene.control.PopupControlBuilder;

import java.util.Set;
import java.util.TreeMap;

public class Person implements  Comparable<Person> {

    private  String name;
    private  int  age;



    @Override
    public int compareTo(Person o) {
        if(this.age>o.getAge()){
            return 1;
        }else  if (this.age<o.getAge()){
            return -1;
        }

        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        TreeMap<Person,String> pdata=new TreeMap<>();
        pdata.put(new Person("张三", 30), "zhangsan");
        pdata.put(new Person("李四", 20), "lisi");
        pdata.put(new Person("王五", 10), "wangwu");
        pdata.put(new Person("小红", 5), "xiaohong");

        Set<Person> people = pdata.keySet();
        for (Person key:people){
            System.out.println(key.getAge()+"-"+key.getName());
        }


    }
}
