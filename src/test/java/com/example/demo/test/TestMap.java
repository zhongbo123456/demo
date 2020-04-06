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
 * @Date: 2020/4/4 23:27
 */
public class TestMap {
    /**
     * map
     */
    @Test
    public void tes1(){
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        System.out.println("----");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    /**
     * flatMap
     */
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa", "bb", "cc");
        Stream<Stream<Character>> streamStream = list.stream().map(TestMap::filterCharter);
        streamStream.forEach(sm->{
            sm.forEach(System.out::println);
        });
        Stream<Character> characterStream = list.stream().flatMap(TestMap::filterCharter);
        System.out.println("-----");
        characterStream.forEach(System.out::println);
    }
    public static Stream<Character> filterCharter(String str){
        List<Character> list=new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
