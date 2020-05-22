package com.example.demo.test;

import com.alibaba.fastjson.JSON;
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
    @Test
    public void test2(){
        int [] a={1,2,3};
        int b []={4,5,6};
        System.out.println(JSON.toJSONString(a));
        System.out.println(JSON.toJSONString(b));

    }
}
