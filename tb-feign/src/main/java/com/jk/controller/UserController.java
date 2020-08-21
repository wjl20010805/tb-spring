package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.entity.TypeEntity;
import com.jk.entity.UserEntity;
import com.jk.service.UserServiceFeign;
import com.jk.service.UserServiceFeigner;
import com.jk.utils.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author wjl
 * @Date @Time 2020/8/19 20:40
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceFeigner userServiceFeign;


    @Resource
    private RedisUtil redisUtil;


    @RequestMapping("/saveOrder")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object saveOrder(Integer userId, Integer productId, HttpServletRequest request) {
        return userServiceFeign.saveOrder(userId, productId);
    }

    public  Object saveOrderFail(Integer userId, Integer productId, HttpServletRequest request) throws Exception {
        HashMap<String, Object> go = PhoneCode.Go("17116500520");
        System.out.println(go);
        return null;
    }



    @RequestMapping("/addUser")
    @ResponseBody
    public Boolean addUser( UserEntity userEntity){
        Boolean aboolean=userServiceFeign.addUser(userEntity);
        return aboolean;
    }


    @RequestMapping("findUserTypeList")
    @ResponseBody
    public List<TypeEntity> findUserTypeList(){
        return userServiceFeign.findUserTypeList();
    }


    @RequestMapping("/findUserList")
    @ResponseBody
    public List<UserEntity> findUserList(){
        return userServiceFeign.findUserList();
    }

    @RequestMapping("/deleteEsByid/{id}")
    @ResponseBody
    public Boolean deleteEsByid(@PathVariable Integer id){

        Boolean aboolean=userServiceFeign.deleteEsByid(id);
        return aboolean;

    }

    @RequestMapping("/selectUserList")
    @ResponseBody
    public List<UserEntity> selectUserList() {
//        (List<UserEntity>) redisUtil.get(Constant.SELECT_USER_LIST);
        List<UserEntity> userList = (List<UserEntity>) redisUtil.get(Constant.SELECT_USER_LIST);

        // 1. 有值   2. 没有值
        if(userList == null || userList.size() <= 0 || userList.isEmpty()) {
            // 从数据库查询，存redis
            userList = userServiceFeign.selectUserList();
            redisUtil.set(Constant.SELECT_USER_LIST, userList, 30);
        }

        return userList;

    }


}
