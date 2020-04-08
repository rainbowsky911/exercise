package com.example.demo.annotation;



import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {

    String value() default "4396";

    String address() default "北京";

}
