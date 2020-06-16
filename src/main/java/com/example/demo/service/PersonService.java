package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.Student1;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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

    List<Student1> getData(List<Student1> list);

    void exportData(HttpServletResponse response,String [] title);

    void excelData(HttpServletResponse response);

    void importData(MultipartFile file);
}
