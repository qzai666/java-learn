package com.itheima;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("用户信息服务测试")
public class UserServiceTest {

    private final UserService userService = new UserService();

    @Test
    @DisplayName("生日当天年龄增加一岁")
    public void testGetAgeOnBirthday() {
        LocalDate birthday = LocalDate.now().minusYears(20);
        String idCard = createIdCard(birthday, '1');

        int age = userService.getAge(idCard);

        assertEquals(20, age);
    }

    @Test
    @DisplayName("今年生日未到时年龄不增加")
    public void testGetAgeBeforeBirthday() {
        LocalDate birthday = LocalDate.now().minusYears(20).plusDays(1);
        String idCard = createIdCard(birthday, '1');

        int age = userService.getAge(idCard);

        assertEquals(19, age);
    }

    @ParameterizedTest(name = "非法身份证：{0}")
    @NullSource
    @ValueSource(strings = { "", "12345678901234567", "1234567890123456789" })
    @DisplayName("身份证为空或长度错误时获取年龄失败")
    public void testGetAgeWithInvalidLength(String idCard) {
        assertThrows(IllegalArgumentException.class, () -> userService.getAge(idCard));
    }

    @Test
    @DisplayName("出生日期格式错误时获取年龄失败")
    public void testGetAgeWithInvalidBirthday() {
        String idCard = "411282199213011012";

        assertThrows(DateTimeParseException.class, () -> userService.getAge(idCard));
    }

    @ParameterizedTest(name = "性别码 {0} 返回 {1}")
    @CsvSource({
            "1, 男",
            "2, 女",
            "9, 男",
            "0, 女"
    })
    @DisplayName("根据身份证性别码返回性别")
    public void testGetGender(String genderCode, String expectedGender) {
        String idCard = createIdCard(LocalDate.of(1992, 10, 7), genderCode.charAt(0));

        String gender = userService.getGender(idCard);

        assertEquals(expectedGender, gender);
    }

    @ParameterizedTest(name = "非法身份证：{0}")
    @NullSource
    @ValueSource(strings = { "", "12345678901234567", "1234567890123456789" })
    @DisplayName("身份证为空或长度错误时获取性别失败")
    public void testGetGenderWithInvalidLength(String idCard) {
        assertThrows(IllegalArgumentException.class, () -> userService.getGender(idCard));
    }

    @Test
    @DisplayName("性别码不是数字时获取性别失败")
    public void testGetGenderWithNonNumericCode() {
        String idCard = createIdCard(LocalDate.of(1992, 10, 7), 'A');

        assertThrows(IllegalArgumentException.class, () -> userService.getGender(idCard));
    }

    private static String createIdCard(LocalDate birthday, char genderCode) {
        return "411282"
                + birthday.format(DateTimeFormatter.BASIC_ISO_DATE)
                + "00"
                + genderCode
                + "X";
    }
}
