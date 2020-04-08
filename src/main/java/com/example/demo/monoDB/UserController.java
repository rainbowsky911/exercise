package com.example.demo.monoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
@RequestMapping("mongo")
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;




    @ResponseBody
    @GetMapping("save")
    public String save(){
        UserInfo userInfo = new UserInfo(System.currentTimeMillis(),"用户"+System.currentTimeMillis(),"123");
        userRepository.save(userInfo);
        return "success";
    }


    @GetMapping("getUserList")
    public String getUserList(Model model){
        List<UserInfo> userInfoList = userRepository.findAll();

       model.addAttribute("userInfo",userInfoList);
        return "muser";
    }

    @ResponseBody
    @GetMapping("delete")
    public String delete(Long id){
        userRepository.deleteById(id);
        return "success";
    }

    @ResponseBody
    @GetMapping("update")
    public String update(Long id,String username,String password){
        UserInfo userInfo = new UserInfo(id,username,password);
        userRepository.save(userInfo);
        return "success";
    }
}