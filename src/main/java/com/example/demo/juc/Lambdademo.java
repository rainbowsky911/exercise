package com.example.demo.juc;

public class Lambdademo {
    public static void main(String[] args) {

       Foo2 foo2=(int x,int y)->{
           return x+y;
        };
      //  foo2.sayhello();
        System.out.println(foo2.add(10,20));
    }
}

interface  Foo2{
   // public  void sayhello();
    public  int add(int x,int y);

    default  int sub(int x,int y){
        return x-y;
    }

}
