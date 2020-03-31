package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.service
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/3/30 17:42
 */
public interface MongoDBService {

    List<Course> getAll();
}
