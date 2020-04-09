package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/6 11:57
 */
public class TestSorted {
    /**
     * sorted()自然排序
     */
    @Test
    public void test1(){
        List<String> list = Arrays.asList("dd", "cc", "bb", "aa");
        list.stream().sorted()
                .forEach(System.out::println);
    }

    /**
     * sorted(Comparator com)---定制排序（Comparator）
     */
    @Test
    public void test2(){

        List<Student> students = Arrays.asList(
                new Student(1, 50, "文化路1"),
                new Student(1, 21, "文化路2"),
                new Student(2, 89, "文化路3"),
                new Student(2, 50, "文化路4"),
                new Student(3, 20, "文化路6"),
                new Student(4, 80, "文化路5")
        );
        students.stream().sorted((e1,e2)->{
            if (e1.getId()==e2.getId()){
                return e1.getAge().compareTo(e2.getAge());
            }else {
                return e1.getAddress().compareTo(e2.getAddress());
            }
        }).forEach(System.out::println);


    }
}
