package com.city.service;

import com.city.pojo.UserModel;

import java.util.List;

public interface IUserService {
    public int insert(UserModel userModel);
    public int update(UserModel userModel);
    public int delete(int id);
    public UserModel login(String username,String password);
    public UserModel selectById(int id);
    public List<UserModel> selectAll();
}
