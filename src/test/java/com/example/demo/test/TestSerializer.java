package com.example.demo.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author:zhongbo
 * @Description: 测试序列化是否按照指定MySerializer序列化
 * @date:  2020/1/15 17:46
 */
public class TestSerializer {
    public static void main(String[] args) {
        Person person=new Person("lisi",20,"a路");
        ObjectMapper objectMapper=new ObjectMapper();
        String s;
        try {
             s = objectMapper.writeValueAsString(person);
            System.out.println("s = " + s);
            //s = {"name":"lisi","age":"20","address":"a路","sex":"男","id":"20147710450"}
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
