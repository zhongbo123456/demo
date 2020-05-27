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

    /**
     * 转义
     */
    @Test
    public void test3(){
        String s="aa|bb|cc|dd";
        String[] split = s.split("\\|");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        String s1="ee//ff//gg";
        String[] split1 = s1.split("\\//");
        for (int i = 0; i < split1.length; i++) {
            System.out.println(split1[i]);
        }

        String s2="hh'ii'jj";
        String[] split2 = s2.split("\'");
        //String[] split2 = s2.split("\\'");
        for (String s3 : split2) {
            System.out.println(s3);
        }

    }
}
