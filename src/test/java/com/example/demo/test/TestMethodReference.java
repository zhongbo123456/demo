package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/4 18:13
 */
public class TestMethodReference {
    /**
     * 对象：：实例方法名
     */
    @Test
    public void test1(){
        Consumer<String> consumer=(x)->System.out.println(x);
        consumer.accept("hello");
        Consumer<String>  consumer1=System.out::println;
        consumer1.accept("hello world");
    }

    /**
     * 类::静态方法名
     */
    @Test
    public void test2(){
        Comparator<Integer> comparator=(x,y)->Integer.compare(x,y);

        Comparator<Integer> comparator1=Integer::compareTo;

    }

    /**
     * 类::实例方法名
     */
    @Test
    public void test3(){
        BiPredicate<String,String> biPredicate=(x,y)->x.equals(y);
        BiPredicate<String,String> biPredicate1=String::equals;
    }

    /**
     * 构造器引用
     */
    @Test
    public void test4(){
        Supplier<Student> supplier=()->new Student();
        Student student = supplier.get();
        System.out.println(student);
        Supplier<Student> supplier1=Student::new;
    }
    /**
     * 数组引用
     *
     */
    @Test
    public void test5(){
        Function<Integer,String[]> function=(x)->new String[x];
        Function<Integer,String[]> function1=String[]::new;
    }
}
