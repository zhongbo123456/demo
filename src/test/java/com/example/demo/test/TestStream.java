package com.example.demo.test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
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
        //list.stream().forEach(person -> System.out.println(person));
        //stream流中filter进行过滤
       // List<Person> collect = list.stream().filter(person -> person.getAge() > 20).collect(Collectors.toList());
        //System.out.println("collect = " + collect);
        /*AtomicInteger a=new AtomicInteger(1001);
        a.set(1);
        System.out.println("a = " + a);
        a.getAndAdd(1);
        System.out.println("a = " + a);*/

       /* Arrays.asList(1,2,3,4,5).stream().forEach(integer ->System.out.println(integer) );
        List<Integer> collect = Arrays.asList(20, 12, 45, 78, 96, 52).stream().filter(integer -> integer > 50).collect(Collectors.toList());
        System.out.println(collect);
        Arrays.asList("aa","bb","cc","ab","ac","yy").stream().filter(s->s.contains("a")).forEach(a->System.out.println(a));*/
        Student student=new Student(1,"ab");
        System.out.println("student:"+student.toString());
        Student student1=new Student(2,"cc");
        System.out.println("age:"+student.getAge());
        if(student.getAge()==student1.getAge()){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

    }
}
