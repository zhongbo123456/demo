package com.example.demo.test;

import org.junit.jupiter.api.Test;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/17 9:17
 */
public class Test10 {
    @Test
    public void test1(){
        Student student=new Student();
        student.setId(2);
        student.setAge(20);
        String s="aa";
        fillWith(student,s);
        System.out.println("student:"+student);
    }
    @Deprecated
    private void fillWith(Student student, String s) {
        student.setAddress(s);
    }
}
