package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Student;
import com.example.demo.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/15 13:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    PersonMapper personMapper;
    @Value("${age:20}")
    private Integer age;

    @Value("#{1}")
    private Integer sex;
    @Value("#{'文化路'}")
    private String address;
    @Value("#{userBean.name}")
    private volatile String name;


    /**
     * @Value用法
     */
    @Test
    public void test3(){
        System.out.println(age);
        System.out.println(sex);
        System.out.println(address);
        System.out.println(name);
    }

    /**
     * Student有一个List<String>属性
     */
    @Test
    public void test1(){
        List<Student> list = personMapper.selectByName("a");
        System.out.println(list.toString());

        List<Student> list1 = personMapper.selectAll();
        System.out.println(list1.toString());
    }

    /**
     * 模糊查询
     */
    @Test
    public void test2(){
        //模糊查询方式1
        List<Student> list1 = personMapper.selectByNameLike("小");
        System.out.println(list1.toString());
        //模糊查询方式2
        List<Student> list2 = personMapper.selectByNameLike1("小");
        System.out.println(list2.toString());

    }



}
