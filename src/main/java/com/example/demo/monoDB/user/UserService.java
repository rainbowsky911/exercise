package com.example.demo.monoDB.user;

import java.util.List;

public interface UserService {

    UserInfo  adduserInfo(UserInfo userInfo);

    void deleteuserInfo(String id);

    UserInfo updateuserInfo(UserInfo userInfo);

    UserInfo finduserInfoById(String id);

    List<UserInfo> findAlluserInfo();
    List<UserInfo> findByNamelike(String name);

}
