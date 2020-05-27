package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Test
    public void test1(){
        String s1="[\n" +
                "{\"hour\":10,\"minute\":20},\n" +
                "{\"hour\":12,\"minute\":40},\n" +
                "{\"hour\":20,\"minute\":50}\n" +
                "]";
        List<Map> list = JSONObject.parseArray(s1, Map.class);
        System.out.println(list.toString());
        Map<String,Integer>[] tm=new Map[list.size()];
        tm=list.toArray(tm);
        for (int i = 0; i < tm.length; i++) {
            System.out.println(tm[i]);
        }
    }
    @Test
    public void test2(){
        Map<String,String> map=new HashMap<>();
        map.put("name","zhangsan");
        map.put("sex","男");
        map.put("address","文化路");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry.getKey());
            System.out.println(stringStringEntry.getValue());
        }
    }
    @Test
    public void test3(){
        Integer s=1221211111;
        System.out.println(s);
    }
}
