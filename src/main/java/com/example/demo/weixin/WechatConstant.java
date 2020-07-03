package com.example.demo.weixin;


/**
 * @ClassName WechatConstant
 * @Author wang.hongyu
 * @Date 2019-12-30
 * @Version V1.0
 **/
public class WechatConstant {
    /**
     * 1.待支付
     * */
    public static final Integer STATUS_FLAG_PAID = 1;

    /**
     * 2.支付成功
     * */
    public static final Integer STATUS_FLAG_SUCCESS = 2;

    /**
     * 3.支付失败
     * */
    public static final Integer STATUS_FLAG_FAIL = 3;

    /**
     * 1.银联
     * */
    public static final Integer TypeFlag_UnionPay = 1;
    /**
     * 2.支付宝
     * */
    public static final Integer TypeFlag_AILIPAY= 2;
    /**
     * 3.微信
     * */
    public static final Integer TypeFlag_WECHATPAY = 3;

    public static final String TOKEN = "kobe2";

    public static final String APPKEY = "8a698a7a6882b88e102ec0b11613bf57";

    public static final String APPID = "wx6107ee59bc1e701d";

    public static final String APPSERCET = "543349317a349a8936abe9130b7969c8";

    public static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSERCET;

}
