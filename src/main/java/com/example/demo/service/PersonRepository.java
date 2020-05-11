package com.example.demo.service;

import com.example.demo.entity.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.service
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/9 14:21
 */
public interface PersonRepository extends MongoRepository<Person, ObjectId> {
    List<Person>  findByAge(Integer age);
    List<Person> findBySex(Integer sex);
}
