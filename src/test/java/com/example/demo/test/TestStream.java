package com.example.demo.test;

import com.example.demo.entity.Student;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestStream {
    public static void main(String[] args) {
        List<Student> list=new ArrayList<>();
       /* list.add(new Student(1,"张三",18,"男"));
        list.add(new Student(2,"李四",19,"男"));
        list.add(new Student(3,"小红",20,"女"));
        list.add(new Student(4,"小紫",21,"女"));
        list.add(new Student(5,"王五",22,"男"));*/
        //迭代器遍历list
        /*Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }*/
        //foreach遍历list
       /* for (Person person : list) {
            System.out.println("person = " + person);
        }*/
       //stream进行循环
        list.stream().forEach(person -> System.out.println(person));
        //stream流中filter进行过滤
       // List<Person> collect = list.stream().filter(person -> person.getAge() > 20).collect(Collectors.toList());
        //System.out.println("collect = " + collect);
        AtomicInteger a=new AtomicInteger(1001);
        a.set(1);
        System.out.println("a = " + a);
        a.getAndAdd(1);
        System.out.println("a = " + a);


    }
}
