/*
package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
*/
/**
 * @author:zhongbo
 *  @Description: 使用BCryptPasswordEncoder类的matches校验密码
 *  @date: 2020/1/15 15:53
 *//*


public class TestBCryptPasswordEncoder {
    @Test
    public void test1(){
        String newPassword="123456";
        String oldPassword="123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //对旧密码加密
        String encodedOldPassword = bCryptPasswordEncoder.encode(oldPassword);
        System.out.println("encodedOldPassword = " + encodedOldPassword);
        boolean matches = bCryptPasswordEncoder.matches(newPassword, bCryptPasswordEncoder.encode(oldPassword));
        System.out.println("matches = " + matches);
    }

}
*/
