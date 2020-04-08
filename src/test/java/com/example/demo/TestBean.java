package com.example.demo;


import com.example.demo.bean.A;
import com.example.demo.bean.B;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestBean {


    @Test
    public void Bean() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(A.class);
        B b = (B) context.getBean("b");


       // b.builder().name("kobe").age(12).build();
       // b.setAge(12);
      //  b.setName("kobe");


        /**
         * bean factory  既是工厂又是注册器
         */
        DefaultListableBeanFactory fctory = context.getDefaultListableBeanFactory();

        RootBeanDefinition beanDefinition =new RootBeanDefinition(B.class);
        fctory.registerBeanDefinition("b",beanDefinition);


        /**
         * Spring 填充属性  后置处理器
         */
        beanDefinition.getPropertyValues().add("name","kobe");

        System.out.println(context.getBean("b"));

    }
}
