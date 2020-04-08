package com.example.demo.interview.join;

public class TestJoin2 implements  Runnable {


    private  String name;

    public TestJoin2(String name) {
        this.name = name;
    }

    public TestJoin2() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread()+"-"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin2 testJoin2 = new TestJoin2();
        Thread t1 =new Thread(testJoin2);
        Thread t2 =new Thread(testJoin2);

        t1.start();
        t1.join();


        t2.start();
        t1.join();


        for (int j = 0; j <50 ; j++) {
            System.out.println(Thread.currentThread().getName()+".."+j);
        }

    }
}
