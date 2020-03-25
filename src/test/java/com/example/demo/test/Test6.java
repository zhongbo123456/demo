package com.example.demo.test;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test6 {
    public static void main(String[] args) {
       /* List<Student> list=new ArrayList<>();
        list.add(new Student(1,20,"a"));
        list.add(new Student(2,20,"b"));
        List<String> collect = list.stream().map(student -> student.getAddress()).collect(Collectors.toList());
        System.out.println(collect.toString());*/

        List<Student> list1=new ArrayList<>();
        list1.add(new Student(1,"a"));
        list1.add(new Student(2,"b"));
        System.out.println(list1.toString());
        list1.forEach(student -> student.setAge(20));
        System.out.println(list1.toString());

        Integer a=10;
        if(a!=null){
            System.out.println("success");
        }


    }
}
