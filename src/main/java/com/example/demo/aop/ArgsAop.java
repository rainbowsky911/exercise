package com.example.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ArgsAop {


    @Pointcut(
            "execution(* com.example.demo.controller..*.*(..))"
    )
    public void agrsAop() {}


    @Before("agrsAop()")
    public void before(JoinPoint point) throws Throwable {
        System.out.println("==>@Before begin----- ");

        Object[] objArgs = point.getArgs();
        for(Object obj : objArgs) {
            System.out.print("args: "+obj + "\t");
        }
        System.out.println();

        System.out.println("==>@Before end----- ");
    }

    @After("agrsAop()")
    public void releaseResource(JoinPoint point) {
        System.out.println("==>@After：目标方法:" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        System.out.println("==>@After：参数:" + Arrays.toString(point.getArgs()));
        System.out.println("==>@After：被织入的目标对象:" + point.getTarget());
    }



}
