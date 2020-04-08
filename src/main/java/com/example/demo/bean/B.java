package com.example.demo.bean;

import lombok.*;

@Data
@Builder
@AllArgsConstructor

@Setter
@Getter
public
class  B{
    private  String name;
    private  int age;

    public B() {
        System.out.println("调用构造器");
    }
}
