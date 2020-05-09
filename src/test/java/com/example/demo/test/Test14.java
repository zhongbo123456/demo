package com.example.demo.test;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/30 16:47
 */
public class Test14 {
    /**
     * CollectionUtils用法
     */
    @Test
    public void test1(){
        List<String> list1 = Arrays.asList("A", "B", "C", "D");
        List<String> list2 = Arrays.asList("C", "D", "E", "F");
        //并集
        Collection<String> union = CollectionUtils.union(list1, list2);
        System.out.println(union.toString());//[A, B, C, D, E, F]
        //交集
        Collection<String> intersection = CollectionUtils.intersection(list1, list2);
        System.out.println(intersection.toString());//[C, D]
        //差集（扣除）
        Collection<String> subtract = CollectionUtils.subtract(list1, list2);
        System.out.println(subtract.toString());//[A, B]
        //集合是否为空
        System.out.println(CollectionUtils.isEmpty(list1));//false
        List<String> list=new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(list));//true
        List<String> list3=null;
        System.out.println(CollectionUtils.isEmpty(list3));//true
        //集合是否相等
        System.out.println(CollectionUtils.isEqualCollection(list1, list2));//false
       List<String> list4=new ArrayList<>();
        System.out.println(CollectionUtils.isEqualCollection(list, list4));//true


    }
    @Test
    public void test2(){
        Student student1=new Student(1,20,"aa",20.0);
        Student student2=new Student(2,21,"bb",20.0);
        Student student3=new Student(1,20,"aa",20.0);
        Student student4=new Student(2,21,"bb",20.0);
        List<Student> list=new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);



    }
}
