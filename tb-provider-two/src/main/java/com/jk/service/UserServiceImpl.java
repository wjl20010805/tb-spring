package com.jk.service;

import com.jk.entity.TypeEntity;
import com.jk.entity.UserEntity;
import com.jk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wjl
 * @Date @Time 2020/8/19 20:41
 *
 */
@RestController
public class UserServiceImpl
        implements UserServiceFeign{

    @Resource
    private UserMapper userMapper;

    @Override
    @RequestMapping("/selectUserList")
    public List<UserEntity> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    @RequestMapping("/findUserList")
    public List<UserEntity> findUserList() {
        return userMapper.findUserList();
    }

    @Override
    @RequestMapping("/deleteEsByid/{id}")
    public Boolean deleteEsByid(@PathVariable Integer id) {
        try {
            userMapper.deleteEsByid(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<TypeEntity> findUserTypeList() {
        return userMapper.findUserTypeList();
    }

    @Override
    public Boolean addUser(@RequestBody UserEntity userEntity) {
        try {
            userMapper.addUser(userEntity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @RequestMapping("/saveOrder")
    public Object saveOrder(@RequestParam Integer userId, @RequestParam Integer productId) {
        Map<String, Object> orderMap = new HashMap<String, Object>();
        orderMap.put("orderId", 11111);
        orderMap.put("userId", userId);
        orderMap.put("productId", productId);
        orderMap.put("orderNo", "20200815103622123");
        orderMap.put("orderName", "一架辽宁舰");
        orderMap.put("orderPrice", 100000);
        orderMap.put("createTime", "2020-08-15 10:37");
        return orderMap;
    }
}
