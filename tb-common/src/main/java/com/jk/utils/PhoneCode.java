package com.jk.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.UUID;

//发送验证码工具类
public class PhoneCode {

    //短信验证请求URL
    public static final String SMS_URL = "https://api.netease.im/sms/sendcode.action";
    //短信AppKey
    public static final String APP_KEY = "3f9365fa7c1e9f643e99c6bf8ac3f2b0";
    //App Secret 密钥
    public static final String APP_SECRET = "a0a23f574fc8";
    //模板ID 14883219
    public static final String TEMPLATEID = "14874366";
//发送验证码
public static   HashMap<String, Object> Go(String phone) throws Exception {
    HashMap<String, Object> map = new HashMap<String, Object>();
    HashMap<String, Object> headers = new HashMap<String, Object>();
    //开发者平台分配的appkey
    headers.put("AppKey", APP_KEY);
    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
    //随机数（最大长度128个字符）
    headers.put("Nonce", uuid);
    //当前UTC时间戳，
    String SystemTime = System.currentTimeMillis() + "";
    headers.put("CurTime", SystemTime);
    //SHA1(AppSecret + Nonce + CurTime),三个参数拼接的字符串，进行SHA1哈希计算，转化成16进制字符(String，小写)
    headers.put("CheckSum", SendCode.getCheckSum(APP_SECRET, uuid, SystemTime));
    HashMap<String, Object> params = new HashMap<String, Object>();
    params.put("mobile","17116500520");
    params.put("templateid", TEMPLATEID);
    //客户自定义验证码，长度为4～10个数字  5位

    params.put("authCode", 12345);
        String post = HttpClientUtil.post(SMS_URL, params, headers);
        JSONObject parseObject = JSON.parseObject(post);
        int code = parseObject.getIntValue("code");
        if (code != 200) {
            map.put("code", 1);
            map.put("msg", "验证码失败！！！");
            map.put("status",parseObject);
            return map;
        }
        map.put("code", 0);
        map.put("msg", "OK");
        map.put("status",parseObject);
        return map;
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, Object> ss = PhoneCode.Go("17116500520");
        System.out.println(ss);
    }
}
