package com.example.demo.jvm;

public class LearnHeap
{

    public static void main(String args[]){

        int a=10;
        Person person = new Person();
        person.age =20;

        change(a,person);
        System.out.println("a="+ a+",and person.age = "+person.age);

    }

    static void change(int a1, Person person){

        a1 = 11;
        person.age= 21;
        System.out.println("a1="+ a1+",and age1 = "+person);

    }
}
class Person {

    int age;

}
