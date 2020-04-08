package com.example.demo.juc;

public class TestSInleton {

    public static void main(String[] args) {

        /**
         * 单线程情况下没事
         */

       /*for (int i = 0; i < 100; i++) {
            Boss.getInstance();
        }*/

        Runnable runnable =()->{
            Boss.getInstance();
        };

        /**
         * 调用100次
         */
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
    }
}
class Boss{

    public Boss() {
        System.out.println("Boss被实例化了");
    }

    private  static volatile  Boss instance =null;

    public    static Boss getInstance(){
            if(instance==null){
                synchronized (Boss.class){
                    if(instance==null){
                        instance=new Boss();
                    }
                }
            }

        return  instance;
    }
}
