package com.example.demo.redis;

public interface GetMessage {


    String getKeyName(User user);

    String getLoginTimeLockKey(User user);

    String getLoginCountFailKey(User user);
}
