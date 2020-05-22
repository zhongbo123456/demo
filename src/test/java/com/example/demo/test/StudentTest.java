package com.example.demo.test;

import com.example.demo.entity.Student;
import com.example.demo.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void test1(){
        List<Student> list = personMapper.selectByName("a");
        System.out.println(list.toString());

        /*List<Student> list1 = personMapper.selectAll();
        System.out.println(list1.toString());*/
    }
}
