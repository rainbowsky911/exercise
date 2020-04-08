package com.example.demo.designPattern;

public class DellFactory implements  AbstractFactory {
    @Override
    public PC makePc() {
        return  new Dell();
    }


}
