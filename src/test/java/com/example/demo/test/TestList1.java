package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhongbo
 * @Description: 测试集合中removeAll方法，集合1.removeAll(集合2)意味着集合1中移除与集合2相同的元素
 * 集合2.removeAll(集合1)意味着集合2中移除与集合1相同的元素
 * @date: 2020/1/7 17:15
 */
public class TestList1 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        list2.add("3");
        list2.add("4");
        list2.add("5");
        list2.add("6");
       /* list1.removeAll(list2);
        System.out.println("list1 = " + list1);*/
        //结果：list1 = [1, 2]
        //list1集合中移除与list2集合中相同的元素


        list2.removeAll(list1);
        System.out.println("list2 = " + list2);
        //结果：list2 = [5, 6]
        //list2集合中移除与list1集合相同的元素


    }
}
