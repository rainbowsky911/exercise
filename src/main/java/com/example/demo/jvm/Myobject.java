package com.example.demo.jvm;

/**
 * @author 51473
 */
public class Myobject {
    public static void main(String[] args) {

        Object object =new Object();
        System.out.println(object.getClass().getClassLoader());

        System.out.println();
        System.out.println();

        Myobject myobject =new Myobject();
        System.out.println(myobject.getClass().getClassLoader().getParent().getParent());
        System.out.println(myobject.getClass().getClassLoader().getParent());
        System.out.println(myobject.getClass().getClassLoader());

    }
}
