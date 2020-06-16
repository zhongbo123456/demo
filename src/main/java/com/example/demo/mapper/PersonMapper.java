package com.example.demo.mapper;

import com.example.demo.entity.Student;
import com.example.demo.entity.Student1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PersonMapper {
    Student selectById(int id);


    Integer insert(Student student);


    List<Student> selectAll();

    List<Student> selectAll1();

    List<Student> selectByName(@Param("name") String name);

    Integer update(Student student);

    List<Student> selectByNameLike(@Param("name") String name);

    List<Student> selectByNameLike1(@Param("name") String name);

    List<Student> selectByNameLike2(@Param("name") String name);

    /**
     * 传入list返回list
     *
     * @param list
     * @return
     */
    List<Student1> getData(@Param("list") List<Student1> list);

    List<Student> queryData();
}
