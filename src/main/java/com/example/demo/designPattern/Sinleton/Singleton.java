package com.example.demo.designPattern.Sinleton;

public class Singleton {

    public  volatile  static  Singleton singleton;

    public  static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return  singleton;
    }

    public Singleton() {
        Singleton.getInstance();
    }
}
