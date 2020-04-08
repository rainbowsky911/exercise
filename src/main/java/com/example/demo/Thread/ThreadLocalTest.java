package com.example.demo.Thread;

public class ThreadLocalTest {

    static  ThreadLocal<String> local= new ThreadLocal<>();

    static void  print(String str){

        //打印当前线程本地内存变量
        System.out.println(str+":"+local.get());

        //清除本地内存的本地变量
        local.remove();
    }

    public static void main(String[] args) {

        Thread t1 =new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("localVal1");
                print("thread1");
                System.out.println("after remove:"+local.get());
            }
        });

        Thread t2 =new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("localVal2");
                print("thread2");
                System.out.println("after remove:"+local.get());
            }
        });

        t1.start();
        t2.start();
    }
}
