package com.example.demo.test;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class TestJSONObject {
    public static void main(String[] args) {
        String s = "[\n" +
                "\t\"zhangsan\",\n" +
                "\t\"lisi\",\n" +
                "\t\"wangwu\"\n" +
                "\t]";
        Object parse = JSONObject.parse(s);
        System.out.println("parse = " + parse);
        //parse = ["zhangsan","lisi","wangwu"]

        List<String> list = JSONObject.parseArray(s, String.class);
        System.out.println("list = " + list);
        //list = [zhangsan, lisi, wangwu]

    }
}
