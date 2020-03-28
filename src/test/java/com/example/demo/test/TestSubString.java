package com.example.demo.test;

import com.alibaba.fastjson.JSON;

import java.io.InputStream;
import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/3/28 10:42
 */
public class TestSubString {
    public static void main(String[]args){
        String s="/pic/ZOtDKJz6YLm/9547a6b833ab515b/2019/2/19/1550541260.jpg";
        System.out.println(s.substring(s.lastIndexOf("/")+1));
        String s1="[1,2,3]";
        List<Integer> list = JSON.parseArray(s1, Integer.class);
        list.stream().forEach(s2->System.out.println(s2));
        String s3="['a','b','c']";
        List<String> list1 = JSON.parseArray(s3, String.class);
        list1.stream().forEach(s4->System.out.println(s4));

    }
}
