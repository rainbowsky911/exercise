package com.example.demo.weixin;

import com.example.demo.weixin.WxService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wang.hongyu
 * @Version V1.02020/04/18
 * 微信公众号模块
 **/
@RequestMapping("/wechat")
@Controller
public class WechatController {
    @GetMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        //校验证签名
        if (WxService.check(timestamp, nonce, signature)) {
            System.out.println("接入成功");
            PrintWriter out = response.getWriter();
            //原样返回echostr参数
            out.print(echostr);
            out.flush();
            out.close();
        } else {
            System.out.println("接入失败");
        }
    }


}