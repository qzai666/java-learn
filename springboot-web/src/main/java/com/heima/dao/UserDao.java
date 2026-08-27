package com.heima.dao;

import java.util.List;

//接口
public interface UserDao {
    // 定义的接口

    /**
     * 加载用户数据的
     */

    public List<String> findAll();
}
