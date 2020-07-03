package com.netty.vert;

import io.vertx.core.Vertx;

public class Demo {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(MyFirstVerticle.class.getName());

    }
}
