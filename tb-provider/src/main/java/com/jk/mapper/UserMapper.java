package com.jk.mapper;

import com.jk.entity.TypeEntity;
import com.jk.entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @Author wjl
 * @Date @Time 2020/8/19 20:41
 *
 */
@Mapper
public interface UserMapper {
    @Select("select * from t_user")
    List<UserEntity> selectUserList();

    @Select("select tu.id,tu.name,tu.gender,tu.birthday,tut.name as typeName from t_user tu LEFT JOIN t_user_type tut on tu.type_id=tut.id")
    List<UserEntity> findUserList();

    @Delete("DELETE From t_user where id=#{value}")
    void deleteEsByid(Integer id);

    @Select("select * from t_user_type")
    List<TypeEntity> findUserTypeList();

    @Insert("INSERT INTO t_user (`name`, `gender`, `birthday`,type_id) VALUES (#{name}, #{gender}, #{birthday},#{typeId})")
    void addUser(UserEntity userEntity);
}
