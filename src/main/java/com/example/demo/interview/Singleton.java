package com.example.demo.interview;

public class Singleton {

    private  static  volatile  Singleton singleton;

    public static Singleton getSingleton() {

        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

    public Singleton() {
        getSingleton();
    }
}
