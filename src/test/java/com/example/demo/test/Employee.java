package com.example.demo.test;

import lombok.Data;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/3 9:43
 */
@Data
public class Employee {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 工资
     */
    private Double salary;
    /**
     * 状态
     */
    private Status status;

    public Employee() {
    }

    public Employee(String name, Integer age, Double salary, Status status) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public enum Status {
        FREE,
        BUSY,
        VOCATION
    }
}

