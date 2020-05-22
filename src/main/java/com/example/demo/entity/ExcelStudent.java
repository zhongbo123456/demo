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
    @ExcelProperty(index = 0)
    private String name;

    /**
     * 年龄
     */
    @ExcelProperty(index = 1)
    private Integer age;

    /**
     * 性别
     */
    @ExcelProperty(index = 2)
    private String sex;

    /**
     * 地址
     */
    @ExcelProperty(index = 3)
    private String address;
}
