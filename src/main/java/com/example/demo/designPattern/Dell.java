package com.example.demo.designPattern;

public class Dell implements  PC {
    public  Dell(){
        this.make();
    }

    @Override
    public void make() {
        System.out.println("dell make PC ");
    }
}
