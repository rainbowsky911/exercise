package com.example.demo.designPattern;

public class TestFactory {
    public static void main(String[] args) {

        AbstractFactory factory = (AbstractFactory) new MacFactory();
        factory.makePc();
    }
}
