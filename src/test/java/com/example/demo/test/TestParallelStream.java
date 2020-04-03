package com.example.demo.test;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/3 16:34
 */
public class TestParallelStream {
    public static void main(String[]args){
        Student student1=new Student(1,20,"科技园1");
        Student student2=new Student(2,21,"科技园2");
        Student student3=new Student(3,22,"科技园3");
        Student student4=new Student(4,23,"科技园4");
        Student student5=new Student(5,24,"科技园5");
        Student student6=new Student(6,25,"科技园6");
        Student student7=new Student(7,26,"科技园7");
        Student student8=new Student(8,27,"科技园8");
        Student student9=new Student(9,28,"科技园9");
        Student student10=new Student(10,29,"科技园10");
        List<Student> list=new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);
        list.add(student8);
        list.add(student9);
        list.add(student10);
        List<Map<String,Object>> total=new ArrayList<>();
     /*   long a1 = System.currentTimeMillis();
        list.parallelStream().forEach(student -> {
            Map<String,Object> map=new HashMap<>();
            map.put("id",student.getId());
            map.put("age",student.getAge());
            map.put("address",student.getAddress());
            total.add(map);
        });
        long a2 = System.currentTimeMillis();
        System.out.println((a2 - a1));//422*/

      /*  String s2 = JSON.toJSONString(total);
        System.out.println(s2);*/
        long a3 = System.currentTimeMillis();
        List<Map<String,Object>> total1=new ArrayList<>();
        list.stream().forEach(student -> {
            Map<String,Object> map=new HashMap<>();
            map.put("id",student.getId());
            map.put("age",student.getAge());
            map.put("address",student.getAddress());
            total1.add(map);
        });
        long a4 = System.currentTimeMillis();
        System.out.println((a4 - a3));//314
        String s3 = JSON.toJSONString(total1);
        System.out.println(s3);


        /*List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15,16,17,18,19,20);
        integers.stream().forEach(s1->System.out.print(s1+"\t"));
        System.out.println();
        integers.parallelStream().forEach(s->System.out.print(s+"\t"));*/
    }
}
