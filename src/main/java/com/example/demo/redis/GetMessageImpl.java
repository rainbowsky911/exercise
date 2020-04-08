package com.example.demo.redis;

import org.springframework.stereotype.Service;

@Service
public class GetMessageImpl implements GetMessage {
    @Override
    public String getKeyName(User user) {
        return "user:" + user.getUsername();
    }

    @Override
    public String getLoginTimeLockKey(User user) {
        return "user:loginTime:lock:" + user.getUsername();
    }

    @Override
    public String getLoginCountFailKey(User user) {
        return "user:loginCount:fail:" + user.getUsername();
    }

}