package com.example.demo.designPattern;

public class MAC implements  PC {
    public  MAC(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("MAC make pc");
    }
}
