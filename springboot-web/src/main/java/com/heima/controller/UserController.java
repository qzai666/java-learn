package com.heima.controller;

import org.springframework.web.bind.annotation.RestController;

import com.heima.pojo.User;
import com.heima.service.UserService;
import com.heima.service.impl.UserServiceImpl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

// controller 层 用于接收请求 响应数据

@RestController
public class UserController {

    private UserService userService = new UserServiceImpl();

    @RequestMapping("/list")
    public List<User> list() {
        // 加载 user.txt
        // InputStream in =
        // this.getClass().getClassLoader().getResourceAsStream("user.txt");
        // ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new
        // ArrayList<>());

        // 处理数据
        // List<User> userList = lines.stream().map(line -> {
        // String[] parts = line.split(",");
        // Integer id = Integer.parseInt(parts[0]);
        // String name = parts[1];
        // String username = parts[2];
        // String password = parts[3];
        // Integer age = Integer.parseInt(parts[4]);

        // LocalDateTime upDateTime = LocalDateTime.parse(parts[5],
        // DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // return new User(id, username, password, name, age, upDateTime);

        // }).toList();

        // return userList;

        List<User> userList = userService.findAll();
        return userList;

    }

}
