package com.itheima;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserService {

    public int getAge(String idCard) {
        if (idCard == null || idCard.length() != 18) {
            throw new IllegalArgumentException("身份证号码不能为空且长度必须为18位");
        }

        // 身份证第7至14位为出生日期，格式为 yyyyMMdd。
        String birthday = idCard.substring(6, 14);
        LocalDate birthDate = LocalDate.parse(birthday, DateTimeFormatter.BASIC_ISO_DATE);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getGender(String idCard) {
        if (idCard == null || idCard.length() != 18) {
            throw new IllegalArgumentException("身份证号码不能为空且长度必须为18位");
        }

        // 身份证第17位为性别顺序码，奇数表示男性，偶数表示女性。
        int genderCode = Character.digit(idCard.charAt(16), 10);
        if (genderCode == -1) {
            throw new IllegalArgumentException("身份证第17位必须是数字");
        }
        // test
        return genderCode % 2 == 1 ? "男" : "女";

    }

}
