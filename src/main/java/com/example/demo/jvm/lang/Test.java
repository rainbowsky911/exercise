package com.example.demo.jvm.lang;

/**
 * @author 51473
 */
public class Test {
    public static void main(String[] args) {


        System.out.println(Test.class.getClassLoader());
        System.out.println(Test.class.getClassLoader().getParent());
    }
}
