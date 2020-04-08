package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("hello")
    public  String getHello(){
        return "Kobe";
    }

    @GetMapping("/book")
    public  String hello(Model model){
        HashMap<String,String> map =new HashMap<>();
        map.put("book","三国演义");
        model.addAttribute("book",map);

        return "hello";
    }

}
