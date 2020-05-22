package com.example.demo.test;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/12 14:29
 */
public class Test18 {
    @Test
    public void test1(){
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        String substring = s.substring(0, 8);
        System.out.println(substring);

    }
}
