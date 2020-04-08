package com.example.demo.controller;


import com.example.demo.dao.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
public class PersonController {

    @RequestMapping("getPeople")
    public Map getPerson(){
        TreeMap<String,Person> map =new TreeMap();
        Person person = Person.builder().id(1).name("张三").sex("男").team("湖人").build();
        Person person2 = Person.builder().id(1).name("李四").sex("男").team("鹈鹕").build();
        Person person3 = Person.builder().id(1).name("王五").sex("男").team("76人").build();

        map.put("1",person);
        map.put("2",person2);
        map.put("3",person3);

        return map;
    }

}
