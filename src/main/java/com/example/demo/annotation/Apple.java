package com.example.demo.annotation;

import lombok.Data;

import java.lang.reflect.Field;

@Data
public class Apple {

    @FruitName("appleX")
    private  String appleName;

    @FruitColor(fruitColor = FruitColor.Color.BULE)
    private  String appleColor;

    @FruitProvider(address = "西安")
    private String appleProvider;

    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }
}

class  TestApple{
    public static void main(String[] args) {

        Apple apple =new Apple();
        System.out.println(apple.toString());
        apple.displayName();

        FruitInfoUtil.getFruitInfo(Apple.class);
    }
}

class  FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz){

        String strFruitName=" 水果名称：";
        String strFruitColor=" 水果颜色：";
        String strFruitProvicer="供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for(Field field :fields){
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName=strFruitName+fruitName.value();
                System.out.println(strFruitName);
            }
            else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor=strFruitColor+fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvicer="供应商地址："+fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }
}