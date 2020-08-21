package com.jk.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author : wjl
 * @date : 16:06 2020/8/20
 * @user : lenovo
 */
@Mapper
public interface UserMapper {

    @Select("select * from tt_user")
    List<Map<String,Object>> selectUserList();
}
