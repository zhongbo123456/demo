package com.example.demo.test;//package com.example.demo.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * @BelongProjecet demo
// * @BelongPackage com.example.demo.test
// * @Description:
// * @Author: zhongbo
// * @Date: 2020/7/6 16:01
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class Test21 {
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @Test
//    public void test1(){
//        String password="$2a$10$IaQrfLsFPy6ORI0oYlBn0.eIWGIDDdpMxofCin3NFWF45I1pFO7U6";
//        boolean matches = passwordEncoder.matches("123456", password);
//        System.out.println("matches:"+matches);
//        String encode = passwordEncoder.encode("123456");
//        System.out.println(encode);
//        boolean matches1 = passwordEncoder.matches("123456", passwordEncoder.encode("123456"));
//        System.out.println("matches1:"+matches1);
//
//    }
//
//
//
//
//}
