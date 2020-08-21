package com.jk.controller;

import com.jk.mapper.UserMapper;
import com.jk.utils.Constant;
import com.jk.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author wjl
 * @Date @Time 2020/8/19 20:38
 *
 */
@Controller
public class UserController {

    @Value("${my.name}")
    String name;

//    @Value("${my.gender}")
//    String gender;

    @Autowired
    private RedisUtil redisUtil;


   @Resource
    private UserMapper userMapper;



    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
       String aaa = "你好，" + name + ", 性别：";
        List<Map<String,Object>> userList = userMapper.selectUserList();
        String aa = (String)redisUtil.get(Constant.A_A_A);
        if(redisUtil.hasKey(Constant.A_A_A)){
            return aa+userList.toString();
        }else {
            redisUtil.set(Constant.A_A_A,aaa,1000);
            return  aaa+userList.toString();
        }

    }

}
