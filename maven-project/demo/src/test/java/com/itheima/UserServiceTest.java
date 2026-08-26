package com.itheima;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("测试用户信息")
public class UserServiceTest {

    @Test
    public void testGetAge() {
        UserService userService = new UserService();
        Integer age = userService.getAge("411282199210071012");
        System.out.println(age);

    }

    @Test
    public void testGetGender() {
        UserService userService = new UserService();
        String gender = userService.getGender("411282199210071012");
        System.out.println(gender);

    }

    /**
     * 断言
     */
    @Test
    public void testGenderWithAssert() {
        UserService userService = new UserService();
        String gender = userService.getGender("411282199210071012");
        Assertions.assertEquals("男", gender, "报错了～～～");
    }

    @Test
    public void testGenderWithAssert2() {
        UserService userService = new UserService();
        String gender = userService.getGender("411282199210071012");
        Assertions.assertEquals("男", gender, "报错了～～～");
    }

    /**
     * 参数化注解
     */
    @DisplayName("用户年龄")
    @ParameterizedTest
    @ValueSource(strings = { "411282199210071012", "411282199110071012" })
    public void testGetAge2(String idCard) {
        UserService userService = new UserService();
        Integer age = userService.getAge(idCard);
        System.out.println(age);

    }
}
