package com.example.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.entity
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/9 13:48
 */
@Data
public class Person {
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别，0:male，1:female
     */
    private Integer sex;
    /**
     * 地址
     */
    private Address address;

    public Person() {
    }

    public Person( String name, Integer age, Integer sex, Address address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }
}
