package com.city.mapper;

import com.city.pojo.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 接口中只能包含抽象方法
 */

@Mapper
public interface UserMapper {
    //添加数据的抽象方法
    @Insert("insert into user (username,password) values (#{username},#{password})")
    int insert(UserModel userModel);

    @Update("update user set username= #{username},password = #{password} where id = #{id}")
    int update(UserModel userModel);

    @Delete("delete from user where id = #{id}")
    int delete(int id);

    @Select("select * from user where username= #{username} and password = #{password}")
    UserModel login(String username,String password);

    @Select("select * from user where id = #{id}")
    UserModel selectById(int id);

    @Select("select * from user")
    List<UserModel> selectAll();
}
