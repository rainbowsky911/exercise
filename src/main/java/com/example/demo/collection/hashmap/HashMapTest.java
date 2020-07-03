package com.example.demo.collection.hashmap;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {


    public static void main(String[] args) {

        HashMap<String,String> hashMap =new HashMap<>();

        hashMap.put("1","2");
        String value=hashMap.put("1","3");
        System.out.println(value);      //3

        System.out.println(hashMap.get("2"));       //NULL
        System.out.println("hhe".hashCode());


        Map<Goods, Integer> goodsMap =new HashMap<> ();
        Goods goods =new Goods(66,"测试商品",666);
        goodsMap.put(goods,66);
        goods.setAmount(8848);



        /*goods =new Goods(66,"测试商品",666);
        goodsMap.put(goods,1);*/

        System.out.println(goodsMap.size());
        System.out.println(goodsMap.get(goods));
        goodsMap.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }
}

@ToString
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
class  Goods{
    private  int id;

    private  String name;

    private  int amount;
}