package com.example.demo.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
/**
 * @author:zhongbo
 * @Description: 将java对象转位json字符串
 * @date:  2020/1/8 9:32
 */
public class TestObjectMapper {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("name", "zhangsan");
        map.put("sex", "男");
        map.put("address","科技园");
        List<Person> list=new ArrayList<>();
        list.add(new Person("zhangsan",20,"科技园"));
        list.add(new Person("lisi",21,"文化路"));
        list.add(new Person("zhaoliu",22,"丰产路"));
        ObjectMapper om=new ObjectMapper();
        try {
            String s = om.writeValueAsString(map);
            System.out.println("s = " + s);
            om.writeValue(new File("D:\\zz.txt"),map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
