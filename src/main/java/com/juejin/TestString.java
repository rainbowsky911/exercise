package com.juejin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class TestString {
    public static void main(String[] args) {


        String[] array = new String[]{"test", "1234", "5678"};
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : array) {
            stringBuilder.append(s).append(";");
        }
// 防止最终拼接字符串为空
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        System.out.println(stringBuilder.toString());



        HashSet set =new HashSet<String>();

        set.add(1);
        set.add(12);
        set.add(2);
        set.add(5);
        set.add(5);
        set.stream().forEach(System.out::println);


        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(1,2);

        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);



        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("1","2");
        
    }


}
