package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/25 19:22
 */
public class Test12 {
    @Test
    public void test1(){
        for (int i = 2700; i <=2750 ; i++) {
            System.out.print(i+",");
        }
    }

    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(10, 11, 12, 13);
        List<Integer> integers = Arrays.asList(1, 2, 3, 5,4);
        List<Student> list1=new ArrayList<>();
        List<Integer> filterList = integers.stream().filter(integer -> integer != 3.).sorted().collect(Collectors.toList());
        System.out.println(filterList);
        list.forEach(integer -> {
            Student student=new Student();
            student.setId(integer);
            filterList.forEach(integer1 -> {
               student.setAge(integer1);

            });
            list1.add(student);
        });
        System.out.println(list1);

    }
}
