package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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

    @Test
    public void test4(){
        Student student=new Student();
        Object o = JSON.toJSON(student);
        JSONObject jsonObject=new JSONObject();
        if(o instanceof JSONObject){
            jsonObject=(JSONObject)o;
        }
        boolean age = jsonObject.containsKey("age");
        boolean id = jsonObject.containsKey("id");
        System.out.println(id);
        System.out.println(age);

    }
    @Test
    public void test5(){
        List<String> list=Arrays.asList("a","b","c");
        List<Integer> list2=Arrays.asList(1,2,3,4);
        List list1=list2;
        for (Object o : list1) {
            if(o instanceof String){
                System.out.println("Stirng:"+o);
            }
            if(o instanceof Integer){
                System.out.println("Integer:"+o);
            }

        }
    }

    /**
     * stream 分组
     */
    @Test
    public void test6(){
        List<Apple> list=new ArrayList<>();
        Apple apple1=new Apple("appleA",10);
        Apple apple2=new Apple("appleA",45);
        Apple apple3=new Apple("appleA",4);
        Apple apple4=new Apple("appleB",22);
        Apple apple5=new Apple("appleB",78);
        Apple apple6=new Apple("appleC",89);
        Apple apple7=new Apple("appleD",35);
        Apple apple8=new Apple("appleE",38);
        list.add(apple1);
        list.add(apple2);
        list.add(apple3);
        list.add(apple4);
        list.add(apple5);
        list.add(apple6);
        list.add(apple7);
        list.add(apple8);
        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Apple::getName, Collectors.counting()));
        System.out.println(collect.toString());

    }

    /**
     * 数组输出Arrays.toString()
     */
    @Test
    public void test7(){
       int [] a={1,2,3,4,5,6};
        String string = Arrays.toString(a);
        System.out.println(string);
    }

}
