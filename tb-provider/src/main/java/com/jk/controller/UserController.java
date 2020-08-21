package com.jk.controller;

import com.jk.entity.TypeEntity;
import com.jk.entity.UserEntity;
import com.jk.service.UserService;
import com.jk.service.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author wjl
 * @Date @Time 2020/8/19 20:40
 *
 */
@RestController
public class UserController implements UserServiceFeign {

    @Autowired
    private UserService userService;

    @Override
    @RequestMapping("/selectUserList")
    public List<UserEntity> selectUserList() {
        return userService.selectUserList();
    }

    @Override
    @RequestMapping("/findUserList")
    public List<UserEntity> findUserList() {
        return userService.findUserList();
    }

    @Override
    @RequestMapping("/deleteEsByid/{id}")
    public Boolean deleteEsByid(@PathVariable Integer id) {
        try {
            userService.deleteEsByid(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<TypeEntity> findUserTypeList() {
        return userService.findUserTypeList();
    }

    @Override
    public Boolean addUser(@RequestBody UserEntity userEntity) {
        try {
            userService.addUser(userEntity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object saveOrder(Integer userId, Integer productId) {
        return null;
    }
}
