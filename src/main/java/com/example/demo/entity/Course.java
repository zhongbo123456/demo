package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.entity
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/3/30 17:43
 */
@Data
public class Course {
    private String name;
    /**
     * 价钱
     */
    private Integer price;

    public Course() {
    }

    public Course(String name, Integer price) {
        this.name = name;
        this.price = price;
    }


}
