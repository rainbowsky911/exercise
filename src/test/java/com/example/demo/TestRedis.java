package com.example.demo;

import com.example.demo.redis.ListService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis
{

  @Autowired
    private RedisTemplate redisTemplate;




    @Test
    public void testString(){

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
    void RedisHashMapKey() throws IOException {
        redisTemplate.opsForHash().put("hashValue","map1","map1-1");
        redisTemplate.opsForHash().put("hashValue","map2","map2-2");

        List<Object> hashList = redisTemplate.opsForHash().values("hashValue");
       // System.out.println("通过values(H key)方法获取变量中的hashMap值:" + hashList);

        Object mapValue = redisTemplate.opsForHash().get("hashValue","map1");
     //   System.out.println("通过get(H key, Object hashKey)方法获取map键的值:" + mapValue);
        Map neMap =new HashMap();


        neMap.put("map3","kobe");
        redisTemplate.opsForHash().putAll("hashValue",neMap);
        Map hashValue = redisTemplate.opsForHash().entries("hashValue");
        System.out.println("通过putAll(H key, Map<? extends HK,? extends HV> m)方法以map集合的形式添加键值对:" + hashValue);
    }

    @Test
    void list() {
        List<String> list1=new ArrayList<String>();
        list1.add("a1");
        list1.add("a2");
        list1.add("a3");

        List<String> list2=new ArrayList<String>();
        list2.add("b1");
        list2.add("b2");
        list2.add("b3");
        redisTemplate.opsForList().leftPush("listkey1",list1);
        redisTemplate.opsForList().rightPush("listkey2",list2);
        List<String> resultList1=(List<String>)redisTemplate.opsForList().leftPop("listkey1");
        List<String> resultList2=(List<String>)redisTemplate.opsForList().rightPop("listkey2");
        System.out.println("resultList1:"+resultList1);
        System.out.println("resultList2:"+resultList2);

    }

    @Autowired
    ListService service;
    @Test
    void listQueue() {
        String id="1001";
     service.listInit(id);

        List<String> list = service.listQueueWait(id);
        System.out.println("当前待执行任务队列");
        for (String s:list
             ) {
            System.out.println(s);

        }

        System.out.println("已完成任务队列");
        List<String> list1 = service.listQueuesucc(id);
        for (String ss:list1
        ) {
            System.out.println(ss);

        }



    }
}
