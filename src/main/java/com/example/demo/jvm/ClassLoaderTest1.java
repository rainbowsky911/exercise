package com.example.demo.jvm;

import sun.misc.Launcher;
import sun.misc.URLClassPath;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest1 {

    public static void main(String[] args) {

        /***
         * 类加载器
         * null表示为引导类加载器
         */
        URL[] bootstrapClassPath = Launcher.getBootstrapClassPath().getURLs();

        for (URL element:bootstrapClassPath
             )
            System.out.println(element.toExternalForm());
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println("扩展类加载器---------------");
        String property = System.getProperty("java.ext.dirs");

        for (String path:property.split(";")
             ) {
            System.out.println(path);
        }

        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);

    }
}
