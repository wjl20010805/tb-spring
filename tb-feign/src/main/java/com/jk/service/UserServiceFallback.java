package com.jk.service;

import com.jk.entity.TypeEntity;
import com.jk.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/error")
@Component
public class UserServiceFallback implements UserServiceFeigner {


    @Override
    public List<UserEntity> selectUserList() {

        System.out.println("熔断处理，方法查询用户集合");
        return null;
    }

    @Override
    public List<UserEntity> findUserList() {
        System.out.println("熔断处理，方法查询用户集合");
        return null;
    }

    @Override
    public Boolean deleteEsByid(Integer id) {
        System.out.println("熔断处理");
        return null;
    }

    @Override
    public List<TypeEntity> findUserTypeList() {
        System.out.println("熔断处理");
        return null;
    }

    @Override
    public Boolean addUser(UserEntity userEntity) {
        System.out.println("熔断处理");
        return null;
    }

    @Override
    public Object saveOrder(Integer userId, Integer productId) {

        System.out.println("熔断处理");

        return null;
    }

//    @Override
//    public List<UserEntity> findUserList() {
//
//        System.out.println("熔断处理，方法查询用户集合");
//
//        //熔断处理。。。 TODO
//
//        return null;
//    }
//
//    @Override
//    public String hello(String name) {
//
//        System.out.println(" 进入了 hello方法 熔断器 ");
//
//        return "请求失败，请检查电脑或手机网络。";
//    }
//
//    @Override
//    public Object saveOrder(Integer userId, Integer productId) {
//
//        System.out.println("进入 保存订单 熔断器类");
//
//        return null;
//    }

}
