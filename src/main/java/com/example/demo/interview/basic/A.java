package com.example.demo.interview.basic;

class  Test{
    public static void main(String[] args) {
        B b = new B();
        b.print();
    }
}

public class A {

    private int a;
    private static int aa = 88;

    static {
        System.out.println("父类代码块" +aa);
    }

    public A() {
        this(11);
        System.out.println("父类构造函数" +a);
    }

    public A(int a) {
        this.a = a;
        System.out.println("父类带参构造函数" +a);
    }

    public void print() {
        System.out.println("父类函数" );
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
class B extends A{

    private int b;
    private static int bb = 100;

    static {
        System.out.println("子类代码块"+bb);
    }

    public B() {
        this(12);
        System.out.println("执行子类构造函数"+b);
    }

    public B(int b) {
        this.b = b;
        System.out.println("子类带参构造函数"+b);
    }

    @Override
    public void print(){
        super.print();
        System.out.println("子类函数");
    }
}