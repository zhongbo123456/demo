package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;


public interface PersonService {
    Student selectById(int id);

    List<Student> selectAll();

    /**
     * 修改操作
     * @param student
     * @return
     */
    Student update(Student student);
}
