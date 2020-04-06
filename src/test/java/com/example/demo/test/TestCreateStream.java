package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/4 22:27
 */
public class TestCreateStream {
    @Test
    public void test1(){
        /**
         *  ①可以通过Collection系列集合提供的stream()或者parallelStream()
         */
        List<Integer> list=new ArrayList<>();
        Stream<Integer> stream = list.stream();
        /**
         * ②通过Arrays中的静态方法stream()获取数组流
         */
        String [] s=new String[10];
        Stream<String> stream1 = Arrays.stream(s);
        /**
         * ③通过Stream类中的静态方法of()
         */
        Stream<String> aa = Stream.of("aa", "bb", "cc");
        /**
         *    ④创建无限流
         *    ④-①迭代
         */
        Stream<Integer> stream2 = Stream.iterate(0, x -> x + 2);
        stream2.limit(10).forEach(System.out::println);
        /**
         * 创建无线流
         *  ④-②生成
         */
        Stream<Double> stream3 = Stream.generate(() -> Math.random());
        stream3.limit(5).forEach(System.out::println);


    }
}
