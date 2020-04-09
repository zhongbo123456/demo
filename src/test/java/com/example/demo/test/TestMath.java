package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/7 10:13
 */
public class TestMath {
    @Test
    public void test1(){
        List<Student> list = Arrays.asList(
                new Student(1, 20, "文化路1"),
                new Student(2, 50, "文化路2"),
                new Student(3, 23, "文化路3"),
                new Student(4, 70, "文化路4"),
                new Student(5, 80, "文化路5")
        );
        boolean b = list.stream().allMatch(e -> e.getAge() > 50);
        System.out.println("b:"+b);
        boolean b1 = list.stream().anyMatch(e -> e.getAge() > 50);
        System.out.println("b1:"+b1);
        boolean b2 = list.stream().noneMatch(e -> e.getAge() > 50);
        System.out.println("b2:"+b2);
        System.out.println("----------------");


    }
    @Test
    public void test2(){
        Student student=null;
        Student student5=new Student(1,20,"文化路");
        //of方法，传入值为空，报空指针异常
       // Optional<Student> student1 = Optional.of(student);
       // System.out.println(student1);
        System.out.println("----------");

        //ofNullable传入得值为空，不会报空指针异常
        //orElse方法和orElseGet方法，传入的值为空时，输出一样的
        Student student2 = Optional.ofNullable(student).orElse(createStudent());

        Student student3 = Optional.ofNullable(student).orElseGet(() -> createStudent());

        System.out.println("----------------");
        //orElse方法和orElseGet方法，传入的值不为空时，orElseGet不会创建Student对象
        Student student6 = Optional.ofNullable(student5).orElse(createStudent());
        Student student7 = Optional.ofNullable(student5).orElseGet(() -> createStudent());
        //orElseThrow方法，传入值为空，可以手动抛出异常
        Student student1 = Optional.ofNullable(student).orElseThrow(() -> new IllegalArgumentException());

    }
    private Student createStudent(){
        System.out.println("createStudent()");
        return new Student(1,1,"文化路");
    }
}
