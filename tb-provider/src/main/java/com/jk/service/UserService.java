package com.jk.service;

import com.jk.entity.TypeEntity;
import com.jk.entity.UserEntity;

import java.util.List;

/**
 * @Author wjl
 * @Date @Time 2020/8/19 20:41
 *
 */
public interface UserService {
    List<UserEntity> selectUserList();

    List<UserEntity> findUserList();

    void deleteEsByid(Integer id);

    List<TypeEntity> findUserTypeList();

    void addUser(UserEntity userEntity);
}
