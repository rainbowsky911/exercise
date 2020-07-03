package com.example.demo.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import sun.util.calendar.BaseCalendar;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class TestLambda {

    public static void main(String[] args) {

        Person person =new Person();
        person.setId(1).setAge(72).setSex("男");

        Person person2 =new Person();
        person2.setId(2).setAge(12).setSex("女");

        Person person3 =new Person();
        person3.setId(3).setAge(23).setSex("男");

        List<Person> personList =new ArrayList<>();
        personList.add(person);
        personList.add(person2);
        personList.add(person3);


        /**
         *  找出年龄大于10的人
         * Person(age=12, sex=女)
         * Person(age=23, sex=男)
         */
        personList.stream().filter((x) -> x.getAge() > 10).forEach(System.out::println);


        /**
         *
         * 过滤
         * 排除掉性别为男的用户
         * 输出 Person(age=12, sex=女)
         */
      personList.stream().filter(a -> !a.getSex().equals("男")).forEach(System.out::println);


        /**
         * 年龄倒序排序
         *输出:
         *  Person(id=1, age=72, sex=男)
         * Person(id=3, age=23, sex=男)
         * Person(id=2, age=12, sex=女)
         */

      personList.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(System.out::println);



        int sum = personList.stream().mapToInt(Person::getAge).sum();
        OptionalInt max = personList.stream().mapToInt(Person::getAge).max();
        OptionalInt min = personList.stream().mapToInt(Person::getAge).min();
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);


        /**
         * map找出val值
         * list转map
         */
        Map<String, Object>map =new HashMap<>();
        map.put("1","faker");
        map.put("2","bang");
        map.put("3","benji");
        map.put("4","khan");

        List<Object> collect = map.entrySet().stream().filter(x -> "benji".equals(x.getValue()))
                .map(x -> x.getValue())
                .collect(Collectors.toList());
        System.out.println(collect);


        Map<Integer, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getId, a -> a, (k1, k2) -> k1));
        personMap.forEach( (k,v)->{System.out.println(k+" "+v);} );



        Student student =new Student(1,"kobe",34);
        Student student1 =new Student(1,"tmac",22);
        Student student2 =new Student(1,"jams",32);
        Student student3 =new Student(1,"yaoming",53);
        Student student4 =new Student(1,"jordan",89);

        List<Student> students = Arrays.asList(student, student1, student2, student3, student4);

        students.stream().filter(x->{
            return x.getAge()%2!=0;
        }).forEach(System.out::println);


        ArrayList <Integer>arrayList =new ArrayList();
        arrayList.add(1);
        arrayList.add(12);
        arrayList.add(3);
        arrayList.add(23);
        arrayList.removeIf(x->x%2==0);
        arrayList.forEach(System.out::println);

    }
}

@EqualsAndHashCode
@Data
@Accessors(chain = true)
@ToString
class Person{

    private  int id;
    private  int age;

    private  String sex;
}
@AllArgsConstructor

@EqualsAndHashCode
@Data
@Accessors(chain = true)
@ToString
class Student{
    private  int id;
    private  String name;
    private  int age;
}