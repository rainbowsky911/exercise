package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    @Autowired
    private RedisTemplate redisTemplate;

    public  void listInit(String id){
        String key ="prod"+id;
        redisTemplate.opsForList().leftPushAll(key,"1商家出货","2小哥发货","3北京海淀某小区","4北京机场南京机场","5机场--建邺区","6建邺区--清荷园");

    }

    public  void  listQuquetouch(String id){
        String key ="prod"+id+"succ";
        redisTemplate.opsForList().leftPush("prod"+id,key);

    }
    public List<String> listQueuesucc(String id){
        String key ="prod"+id+"succ";
        return redisTemplate.opsForList().range(key,0,-1);
    }

    public  List<String> listQueueWait(String id){
        String key ="prod"+id;
        return redisTemplate.opsForList().range(key,0,-1);
    }


}
