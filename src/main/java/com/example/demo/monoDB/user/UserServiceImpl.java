package com.example.demo.monoDB.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserInfo adduserInfo(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }

    @Override
    public void deleteuserInfo(String id) {
        userRepository.deleteById(Long.parseLong(id));

    }

    @Override
    public UserInfo updateuserInfo(UserInfo userInfo) {
        UserInfo byId = this.finduserInfoById(String.valueOf(userInfo.getId()));
        if (byId != null) {
            byId.setId(userInfo.getId())
                    .setPassword(userInfo.getPassword())
                    .setUsername(userInfo.getUsername())
            ;
            return userRepository.save(byId);
        } else {
            return null;
        }
    }

        @Override
        public UserInfo finduserInfoById(String id) {
        return userRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public List<UserInfo> findAlluserInfo() {
        return userRepository.findAll();
    }

    @Override
    public List<UserInfo> findByNamelike(String name) {

        return userRepository.findByUsernameLike(name);
    }
}
