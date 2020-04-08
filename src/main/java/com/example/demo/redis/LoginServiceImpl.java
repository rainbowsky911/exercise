package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    GetMessageImpl getMessage;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 验证用户是密码是否正确
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        if (user.getUsername().equals("dlf")) {      //模仿从数据库中根据username查询密码  然后验证密码是否正确
            if (user.getPassword().equals("dlf")) {
                return user;
            }
        }
        return null;
    }

    @Override
    public String loginValdata(User user) {
        return null;
    }

    /**
     * 判断当前登录的用户是否被限制登录
     * 查询当前key是否存在,如果存在,就被限制,注意:需要给用户做提示:您当前的用户已被限制,还剩多长时间
     * 如果不存在就不被限制
     *
     * @param user
     * @return
     */
    @Override
    public Map<String, Object> loginUserLock(User user) {
        Map<String, Object> map = new HashMap<>();
        if (stringRedisTemplate.hasKey(getMessage.getLoginTimeLockKey(user))) {
            //如果存在就是用户已经输错了密码五次 被锁定了俩小时
            map.put("flag", true);  //表示用户已经被锁定
            map.put("lockTime", stringRedisTemplate.getExpire(getMessage.getLoginTimeLockKey(user), TimeUnit.MINUTES));     //得到被锁定之后还剩下多少时间  以分钟返回
        } else {
            map.put("flag", false);   //flag 为false 表示用户没有被限制
        }
        return map;
    }


    /**
     * 登录失败的相应操作(密码错误)
     *
     * @param user
     * @return
     */

    @Override
    public String loginValdate(User user) {

        Integer num = 5;
        //记录登录错误次数的key
        String key = getMessage.getLoginCountFailKey(user);
        if (!stringRedisTemplate.hasKey(key)) {   //如果不存在
            //是第一次登录失败 次数为1
            // userlogincountfile;用户名进行赋值   同时设置失效期2分钟
            stringRedisTemplate.opsForValue().set(key, "1", 2, TimeUnit.MINUTES);
            return "登录失败,在2分钟内还允许输入错误" + (num - 1) + "次";
        } else {
            //如果存在
            //查询登录失败次数
            long loginFilCount = Long.parseLong(stringRedisTemplate.opsForValue().get(key));
            if (loginFilCount < (num - 1)) {    //代表当前如果登录次数小于4  意思:还有资格继续进行登录
                //登录次数+1
                stringRedisTemplate.opsForValue().increment(key, 1);
                long secends = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);  //返回的是秒
                return user.getUsername() + "登录失败,在" + secends + "秒内还允许输入错误" + (num - loginFilCount - 1) + "次";
            } else {   //超过了指定的登录次数
                String lockkey = getMessage.getLoginTimeLockKey(user);
                stringRedisTemplate.opsForValue().set(lockkey, "1", 1, TimeUnit.HOURS);
                return "因登录失败此时超过" + num + "次,以对其限制登录1小时";
            }
        }
    }

    @Override
    public Boolean DeleteMemory(String key) {
        try {
            stringRedisTemplate.delete(key);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}

