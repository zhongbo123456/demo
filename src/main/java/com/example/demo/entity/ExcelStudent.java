package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.entity
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/22 17:37
 */
public class ExcelStudent extends BaseRowModel {
    /**
     * 姓名
     */
    @ExcelProperty(index = 0,value = "姓名")
    private String name;

    /**
     * 年龄
     */
    @ExcelProperty(index = 1,value = "年龄")
    private Integer age;

    /**
     * 性别
     */
    @ExcelProperty(index = 2,value = "性别")
    private String sex;

    /**
     * 地址
     */
    @ExcelProperty(index = 3,value = "地址")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
