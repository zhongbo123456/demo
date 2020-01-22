package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    Student selectById(int id);


    List<Student> selectAll();

    Integer update(Student student);
}
