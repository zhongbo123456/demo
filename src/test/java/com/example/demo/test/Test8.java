package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/3 11:22
 */
public class Test8 {
    public static void main(String[]args){
        List<Student> totalResultList = new ArrayList<>();
        Student s1=new Student();
        Student s2=new Student();
        s1.setAge(1);
        s2.setAge(2);
        totalResultList.add(s1);
        totalResultList.add(s2);
        totalResultList.stream().forEach(student -> {
            student.setAge(5);
        });

        totalResultList.stream().forEach(student -> {
            System.out.println(student.getAge());
        });
    }

}
