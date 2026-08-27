package com.heima.service;

import java.util.List;

import com.heima.pojo.User;

public interface UserService {

    /**
     * 查询所有用户信息
     * 
     */
    public List<User> findAll();

}
