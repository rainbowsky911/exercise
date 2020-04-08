package com.example.demo.redis;




import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class userlogin {
    @Autowired
    LoginServiceImpl loginService;
    @Autowired
    GetMessageImpl getMessage;

    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);

        Map<String, Object> map = loginService.loginUserLock(user);   //登录 验证第一层  看用户是否被限制登录

        if ((Boolean) map.get("flag")) {   //如果为true表示被限制登录
            return "登录失败,因" + username + "超过了限制登录次数,已被禁止登录.还剩" + map.get("lockTime") + "分钟";

        } else {   //表示没有被限制登录   执行 下一步登录逻辑

            User user1 = loginService.login(user);  //执行登录功能

            if (user1 != null) {   //表示密码正确  登录成功
                /**
                 * 清空对应的所有key
                 */
                loginService.DeleteMemory(getMessage.getLoginCountFailKey(user));
                loginService.DeleteMemory(getMessage.getLoginTimeLockKey(user));
                loginService.DeleteMemory(getMessage.getKeyName(user));

                return "登录成功";
            } else {  //登录不成功   计入登录此时 等逻辑操作
                return loginService.loginValdate(user);
            }


        }

    }


    @RequestMapping("/tologin")
    public String tologin() {
        return "login";
    }

}

