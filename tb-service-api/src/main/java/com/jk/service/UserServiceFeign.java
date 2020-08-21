package com.jk.service;

import com.jk.entity.TypeEntity;
import com.jk.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author wjl
 * @Date @Time 2020/8/19 20:41
 *
 */
@FeignClient(value = "tb-provider-two")
public interface UserServiceFeign {


    @RequestMapping("/selectUserList")
    List<UserEntity> selectUserList();

    @RequestMapping("/findUserList")
    List<UserEntity> findUserList();

    @RequestMapping("/deleteEsByid/{id}")
    Boolean deleteEsByid(@PathVariable Integer id);

    @RequestMapping("/findUserTypeList")
    List<TypeEntity> findUserTypeList();

    @RequestMapping("/addUser")
    Boolean addUser(UserEntity userEntity);

    @RequestMapping("/saveOrder")
    Object saveOrder(@RequestParam Integer userId,@RequestParam Integer productId);
}
