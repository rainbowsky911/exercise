package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Test
    public void sb() {
        StringBuilder stringBuilder =new StringBuilder(1024);
        stringBuilder.append(1)
                .append("kobe")
                .append('c')
                .insert(0,"好");
        System.out.println(stringBuilder.toString());
    }


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testStrin2g(){
        //操作String类型的数据
        ValueOperations<String, String> valueStr = redisTemplate.opsForValue();
        //存储一条数据
        valueStr.set("goodsProdu","长安");
        //获取一条数据并输出
        String goodsName = valueStr.get("goodsProdu");
        System.out.println(goodsName);
        //存储多条数据
        Map<String,String> map = new HashMap<>();
        map.put("goodsName","福特汽车");
        map.put("goodsPrice","88888");
        map.put("goodsId","88");

        valueStr.multiSet(map);
        //获取多条数据
        System.out.println("========================================");
        List<String> list = new ArrayList<>();
        list.add("goodsName");
        list.add("goodsPrice");
        list.add("goodsId");
        list.add("goodsProdu");

        List<String> listKeys = valueStr.multiGet(list);
        for (String key : listKeys) {
            System.out.println(key);
        }


    }


    @Test
    void Adder_test() {
        Adder adder = new Adder();
        adder.add(3)
                .add(5)
                .inc(10)
                .add(10);
        System.out.println(adder.value());
    }

    @Test
    void boxing() {
        Integer n =100;
        int i =n;
        System.out.println(i);

        Integer n2=null;
        int i2=n2;
        System.out.println(i2);
    }

    @Test
    void hashSetTest() {

        String s1=new String("aaa");
        String s2=new String("aaa");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        HashSet<Object> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    void testSet() {

        HashSet<Object> objects = new HashSet<>();

        objects.add(new Student(1,"zhangsan"));
        objects.add(new Student(1,"zhangsan"));
        objects.add(new Student(2,"lisi"));
        objects.add(new Student(3,"wangwu"));

        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}


class  Adder{

    private  int sum=0;

    public  Adder add(int n){
        sum+=n;
        return this;
    }
    public  Adder inc(int n){
        sum+=n;
        return  this;
    }
    int value(){
        return  sum;
    }
}





class Student{
        int num;
        String name;

    public Student(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return num == student.num &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}