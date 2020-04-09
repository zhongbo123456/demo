package com.example.demo.test;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/4 23:48
 */
public class TestAddAll {
    @Test
    public void test1(){
        List<String> list = Arrays.asList("aa", "bb", "cc");
        List list1=new ArrayList<>();
        list1.add(11);
        list1.add(22);
        //list1.add(list);
        System.out.println(list1);//[11, 22, [aa, bb, cc]]
        list1.addAll(list);
        System.out.println(list1);//[11, 22, aa, bb, cc]

    }
}
