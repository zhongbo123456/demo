package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:  optional
 * @Author: zhongbo
 * @Date: 2020/4/9 16:41
 */
public class Test9 {
    @Test
    public void test1(){
        //①of方法
        //调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("zhangsan");
        //传入参数为null，抛出NullPointerException.
        //Optional<String> someNull = Optional.of(null);

        //下面创建了一个不包含任何值的Optional实例
        //例如，值为'null'
        //②ofNullable方法
        Optional empty = Optional.ofNullable(null);

        //③ifPresent方法
        name.ifPresent(e->System.out.println("hello"));//hello
        empty.ifPresent(e->System.out.println("world"));//null
        //④orElse方法
        System.out.println(empty.orElse("value is null"));//value is null
        System.out.println(name.orElse("value is not null"));//zhangsan


        //⑤orElseGet
        //orElseGet与orElse方法类似，区别在于orElse传入的是默认值，
        //orElseGet可以接受一个lambda表达式生成默认值。
        //输出：Default Value
        System.out.println(empty.orElseGet(() -> "Default Value"));
        //输出：zhangsan
        System.out.println(name.orElseGet(() -> "Default Value"));

        //map方法执行传入的lambda表达式参数对Optional实例的值进行修改。
        //为lambda表达式的返回值创建新的Optional实例作为map方法的返回值。
        Optional<String> upperName = name.map((value) -> value.toUpperCase());
        System.out.println(upperName.orElse("No value found"));


        //flatMap与map（Function）非常类似，区别在于传入方法的lambda表达式的返回类型。
        //map方法中的lambda表达式返回值可以是任意类型，在map函数返回之前会包装为Optional。
        //但flatMap方法中的lambda表达式返回值必须是Optionl实例。
        upperName = name.flatMap((value) -> Optional.of(value.toUpperCase()));
        System.out.println(upperName.orElse("No value found"));//ZHANGSAN

        //filter方法检查给定的Option值是否满足某些条件。
        //如果满足则返回同一个Option实例，否则返回空Optional。
        Optional<String> longName = name.filter((value) -> value.length() > 6);
        System.out.println(longName.orElse("The name is less than 6 characters"));//zhangsan


    }
}
