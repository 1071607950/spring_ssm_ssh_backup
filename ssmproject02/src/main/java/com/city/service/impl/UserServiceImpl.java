package com.city.service.impl;


import com.city.mapper.UserMapper;
import com.city.pojo.UserModel;
import com.city.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    //创建Mapper层对象
    @Autowired
    private UserMapper userMapper;

    //编写方法调用Mapper层添加数据方法
    public int insert(UserModel userModel){
        return userMapper.insert(userModel);
    }

    public int update(UserModel userModel) {
        return userMapper.update(userModel);
    }

    public int delete(int id){
        return userMapper.delete(id);
    }

    public UserModel login(String username,String password){
        return userMapper.login(username,password);
    }

    public UserModel selectById(int id){return userMapper.selectById(id);}

    public List<UserModel> selectAll(){ return userMapper.selectAll(); }
}
