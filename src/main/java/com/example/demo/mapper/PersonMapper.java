package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper {
    Student selectById(int id);


    List<Student> selectAll();

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
    List<Student> getData(@Param("list") List<Student> list);

}
