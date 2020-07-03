package com.example.demo.monoDB.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserinfoController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public UserInfo addUserInfo(@RequestBody UserInfo userInfo){
        return userService.adduserInfo(userInfo);
    }

    @PutMapping("/update")
    public UserInfo updateUserInfo(@RequestBody UserInfo userInfo){
        return userService.updateuserInfo(userInfo);
    }

    @GetMapping("/{id}")
    public UserInfo findUserInfoById(@PathVariable("id") String id){
        return userService.finduserInfoById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserInfoById(@PathVariable("id") String id){
        userService.deleteuserInfo(id);
    }

    @GetMapping("/list")
    public List<UserInfo> findAllUserInfo(){
        return userService.findAlluserInfo();
    }

}
