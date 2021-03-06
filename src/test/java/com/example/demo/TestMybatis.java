package com.example.demo;


import com.example.demo.mybatis.User;
import com.example.demo.mybatis.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybatis {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void mybatis() {
        List<User> all = userMapper.getAll();

        all.forEach(s-> System.out.println(s));

    }
}
