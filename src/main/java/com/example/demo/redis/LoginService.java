package com.example.demo.redis;

import java.util.Map;

public interface LoginService {

    /**
     * 验证用户登录的账号和密码
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户在2分钟内 仅允许输入错误密码五次,如果超过次数,限制其登录一小时
     *
     * 给用户详细信息提示
     * @param user
     * @return
     */
    String loginValdata(User user);

    /**
     * 判断当前的登录用户是否被限制登录
     * @param user
     * @return
     */
    Map<String,Object> loginUserLock(User user);

    /**
     * 登录不成功的操作(密码错误)
     * @param user
     * @return
     */
    String loginValdate(User user);

    /**
     * 删除登录失败所存入的键值对
     * @param key
     * @return
     */
    Boolean DeleteMemory(String key);


}
