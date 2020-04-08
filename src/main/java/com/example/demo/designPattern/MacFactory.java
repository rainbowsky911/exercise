package com.example.demo.designPattern;

public class MacFactory implements  AbstractFactory {

    @Override
    public PC makePc() {
        return new MAC();
    }


}
