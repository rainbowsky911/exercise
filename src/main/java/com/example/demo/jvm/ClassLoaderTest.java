package com.example.demo.jvm;

public class ClassLoaderTest {

    public static void main(String[] args) {

        java.lang.ClassLoader classLoader = String.class.getClassLoader();

        //ClassLoader parent = String.class.getClassLoader().getParent();


        //System.out.println(parent);
        System.out.println(classLoader);
        System.out.println("==================");
        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getParent());
    }

}
