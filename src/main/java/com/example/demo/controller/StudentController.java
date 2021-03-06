package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.model.MyResult;
import com.example.demo.service.PersonService;
import com.example.demo.utils.MyResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
@Validated
public class StudentController {
    @Autowired
    PersonService personService;

        /**
         * @MethodName:  selectById
         * @param id
         * @Description: 根据id查询
         * @author: zhongbo
         * @date:  2020/1/19 16:09
         */
    @GetMapping("/select/{id}")
    public MyResult<Student> selectById(@PathVariable int id){
        Student p=personService.selectById(id);
        return MyResultUtils.success(p);

    }
        /**
         * @MethodName:  selectAll
         * @param
         * @Description: 查询所有
         * @author: zhongbo
         * @date:  2020/1/19 16:09
         */
    @GetMapping("/selectAll")
    public MyResult<List<Student>> selectAll(){
      List<Student> studentList = personService.selectAll();
      return MyResultUtils.success(studentList);
    }

    /**
     * @MethodName:  update
     * @param student
     * @Return com.example.demo.model.MyResult<com.example.demo.entity.Student>
     * @Description:
     * @author: zhongbo
     * @date:  2020-01-22 17:40
     */
    @PutMapping("/update")
    public MyResult<Student> update(@Valid Student student){
        Student p=personService.update(student);
        return MyResultUtils.success(p);


    }



}
