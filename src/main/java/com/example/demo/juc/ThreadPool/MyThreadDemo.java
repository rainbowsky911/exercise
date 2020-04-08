package com.example.demo.juc.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadDemo {
    public static void main(String[] args) {

        /**
         * 核心线程数量5  最多数量10  无界队列  超出线程存活时间
         */
        new ThreadPoolExecutor(5,
                10,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

    }
}
