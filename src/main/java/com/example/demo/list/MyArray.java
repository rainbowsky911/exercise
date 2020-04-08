package com.example.demo.list;

import java.util.ArrayList;

public class MyArray {

    public static void main(String[] args) {

        ArrayList arrayList =new ArrayList();
        arrayList.add("1");
        /*创建一个数组*/
        Object[] objectArray = new Object[10];
        for (int i = 0; i < 10; i++) {
            objectArray[i] = i;
        }
        System.out.println("原数组");
        for (int i = 0; i < objectArray.length; i++) {
            System.out.print(objectArray[i] + ",");
        }
        System.out.println();
        System.out.println("插入后的数组");
        Object[] newArray;
        try {
            newArray = MyArray.add(objectArray, 3, "hello");
            for (int i = 0; i < newArray.length; i++) {
                System.out.print(newArray[i] + ",");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*在一个数组的任意位置插入一个元素*/
    public static Object[] add(Object[] objectArray, int index, Object object) throws Exception {
        if(index < 0 || index - objectArray.length > 0) {
            throw new Exception("数组索引无效" + index);
        }
        Object[] newObjectArray = new Object[objectArray.length];
        /*首先将插入位置之前的所有元素拷贝到一个新的数组中*/
        for (int i = 0; i < index; i++) {
            newObjectArray[i] = objectArray[i];
        }
        /*然后将剩下的元素拷贝到插入位置加1后面的位置*/
        for (int i = index + 1; i < objectArray.length; i++) {
            if(!"".equals(objectArray[i])) {
                newObjectArray[i] = objectArray[i - 1];
            }
        }
        /*将新增的元素放到插入的位置*/
        newObjectArray[index] = object;
        return newObjectArray;
    }
}
