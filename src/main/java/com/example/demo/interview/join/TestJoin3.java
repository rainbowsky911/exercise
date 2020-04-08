package com.example.demo.interview.join;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TestJoin3  implements  Runnable {
    private  String name;


    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(name+"--"+i);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        TestJoin3 t1 =new TestJoin3("A");
        TestJoin3 t2 =new TestJoin3("B");

        Thread thread =new Thread(t1);
        Thread thread2 =new Thread(t2);

        thread.start();
        thread.join();

        thread2.start();
        thread2.join();
    }
}
