package com.example.demo.Thread;

public class Mythread extends  Thread {

    private int i = 0;
    @Override
    public void run(){
        super.run();
        try {
            this.stop();
        } catch (ThreadDeath e) {
            System.out.println("进入异常catch");
            e.printStackTrace();
        }
    }
}


class  Run{
    public static void main(String[] args) {

        Thread thread = new Mythread();
        thread.start();


    }
}