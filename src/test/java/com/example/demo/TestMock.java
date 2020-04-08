package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMock {

    @Test

    public void dummy() {

        TreeMap<String,Person> map =new TreeMap();
        Person person = Person.builder().id(1).name("张三").sex("男").team("湖人").build();
        Person person2 = Person.builder().id(1).name("李四").sex("男").team("鹈鹕").build();
        Person person3 = Person.builder().id(1).name("王五").sex("男").team("76人").build();

        map.put("1",person);
        map.put("2",person2);
        map.put("3",person3);
        for(Map.Entry<String, Person> entry : map.entrySet()){
            String mapKey = entry.getKey();
            Person mapValue = entry.getValue();
            System.out.println(mapKey+":"+mapValue);
        }
    }

}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Person {

    private  int id ;
    private  String team;
    private String name;
    private  String sex;
}