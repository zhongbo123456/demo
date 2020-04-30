package com.example.demo.test;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/15 13:17
 */
public class TestParseArray {
    public static void main(String[]args){
        String s="[\n" +
                "\t{\n" +
                "\t\"name\":\"zhansan\",\n" +
                "\t\"age\":20\n" +
                "},\n" +
                "\t{\n" +
                "\t\"name\":\"lisi\",\n" +
                "\t\"age\":24\n" +
                "}\n" +
                "\n" +
                "]";
        List<Map> maps = JSON.parseArray(s, Map.class);
        maps.stream().forEach(System.out::println);
    }
}
