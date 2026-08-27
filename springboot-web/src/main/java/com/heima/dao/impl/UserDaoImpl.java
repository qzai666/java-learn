package com.heima.dao.impl;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.heima.dao.UserDao;

import cn.hutool.core.io.IoUtil;

// dao 层用于数据访问
//实现类
public class UserDaoImpl implements UserDao {

    // 加载数据的
    @Override
    public List<String> findAll() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());

        return lines;
    }

}
