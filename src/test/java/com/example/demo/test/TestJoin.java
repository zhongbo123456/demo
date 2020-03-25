package com.example.demo.test;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class TestJoin {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        String join = StringUtils.join(integers, ",");
        System.out.println(join);//1,2,3,4,5,6,7,8,9
    }
}
