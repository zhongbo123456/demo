package com.example.demo.test;

import com.alibaba.fastjson.JSON;
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

        String s1="{\"name\":\"zhangsan\",\"age\":20}";
        JSONObject jsonObject = JSON.parseObject(s1);
        String name = (String) jsonObject.get("name");
        System.out.println(name);
        Integer age = (Integer) jsonObject.get("age");
        System.out.println(age);

    }
}
