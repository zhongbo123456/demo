package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description: Lambda表达式
 * @Author: zhongbo
 * @Date: 2020/4/4 14:40
 */

public class TestLambda {
    /**
     * 语法格式一：无参数，无返回值
     * （）->System.out.println("Hello Lambda!");
     */
    @Test
    public void test(){
        Runnable runnable=()->System.out.println("Hello Lambda!");
        runnable.run();
    }
    /**
     *语法格式二：有一个参数，并且无返回值
     */
    @Test
    public void test1(){
        Consumer<String> consumer=(x)->System.out.println(x);
        consumer.accept("你好");
    }

    /**
     * 语法格式三：若只有一个参数，小括号可以省略不写
     * x->System.out.println(x)
     */
    @Test
    public void test2(){
        Consumer<String> consumer=x->System.out.println(x);
        consumer.accept("hello world");

    }
    /**
     * 语法格式四：有两个以上的参数，有返回值，并且Lambda体重有多条语句
     */
    @Test
    public void test3(){
        Comparator<Integer> comparator=(x,y)->{
            System.out.println("函数式接口");
           return Integer.compare(x,y);
        };
    }

    /**
     * 语法格式五：若Lambda体中只有一条语句，return 和大括号可以省略不写
     */
    @Test
    public void test4(){
        Comparator<Integer> comparator=(x,y)->Integer.compare(x,y);
    }

    @Test
    public void test5(){
        Integer suan = suan(10, x -> x * x);
        System.out.println(suan);

    }

    public Integer suan(Integer integer,MyFun myFun){
        return myFun.getValue(integer);
    }



}
