package com.example.demo.stream;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestStream {

    public static void main(String[] args) {

     /*   List<String> list = new ArrayList<String>() {
            {
                add("user1");
                add("user2");
            }
        };
        Optional<String> opt = Optional.of("");
        opt.ifPresent(list::add);
        list.forEach(System.out::println);

    }*/
        //List<String> platformList = new ArrayList<>();

        List<String> platformList = new CopyOnWriteArrayList<>();
        platformList.add("博客园");
        platformList.add("CSDN");
        platformList.add("掘金");

        for (String platform : platformList) {
            if (platform.equals("博客园")) {
                platformList.remove(platform);
            }
        }

        System.out.println(platformList);

    }
}

