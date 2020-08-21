package com.jk.service;

import com.jk.entity.TypeEntity;
import com.jk.entity.UserEntity;
import com.jk.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wjl
 * @Date @Time 2020/8/19 20:41
 *
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserEntity> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public List<UserEntity> findUserList() {
        return userMapper.findUserList();
    }

    @Override
    public void deleteEsByid(Integer id) {
        userMapper.deleteEsByid(id);
    }

    @Override
    public List<TypeEntity> findUserTypeList() {
        return userMapper.findUserTypeList();
    }

    @Override
    public void addUser(UserEntity userEntity) {
        userMapper.addUser(userEntity);
    }
}
