package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.model.MyResult;

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

    MyResult update(Course course);

    void delete(String name);

    Course add();
}
