package com.example.demo.interview;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapdemo1 {
    public static void main(String[] args) {

        Map<Long, String> mReqPacket = new ConcurrentHashMap<>();
        for (long i = 0; i < 15; i++) {
            mReqPacket.put(i, i + "");
        }

        for (Map.Entry<Long,String> entry:mReqPacket.entrySet()) {
            long key =entry.getKey();
            if(key<10){
                mReqPacket.remove(key);
            }
        }

        for (Map.Entry<Long, String> entry : mReqPacket.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
