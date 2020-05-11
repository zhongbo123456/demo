package com.example.demo.service;

import com.example.demo.entity.Course;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.service
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/9 13:19
 */
public interface CourseRepository extends MongoRepository<Course,ObjectId> {
    List<Course> findAllByPrice(Integer price);
    List<Course> findByName(String name);
}
