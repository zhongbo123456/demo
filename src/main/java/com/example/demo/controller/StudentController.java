package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.entity.Student1;
import com.example.demo.model.MyResult;
import com.example.demo.service.PersonService;
import com.example.demo.utils.MyResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
@Validated
public class StudentController {
    @Autowired
    PersonService personService;

    /**
     * @param id
     * @MethodName: selectById
     * @Description: 根据id查询
     * @author: zhongbo
     * @date: 2020/1/19 16:09
     */
    @GetMapping("/select/{id}")
    public MyResult<Student> selectById(@PathVariable int id) {
        Student p = personService.selectById(id);
        return MyResultUtils.success(p);

    }

    /**
     * @param
     * @MethodName: selectAll
     * @Description: 查询所有
     * @author: zhongbo
     * @date: 2020/1/19 16:09
     */
    @GetMapping("/selectAll")
    public MyResult<List<Student>> selectAll() {
        List<Student> studentList = personService.selectAll();
        return MyResultUtils.success(studentList);
    }

    /**
     * @param student
     * @MethodName: update
     * @Return com.example.demo.model.MyResult<com.example.demo.entity.Student>
     * @Description:
     * @author: zhongbo
     * @date: 2020-01-22 17:40
     */
    @PutMapping("/update")
    public MyResult<Student> update(@Valid Student student) {
        Student p = personService.update(student);
        return MyResultUtils.success(p);

    }

    @PostMapping("/getData")
    public MyResult<List<Student1>> getData(@RequestBody List<Student1> list) {
        List<Student1> list1 = personService.getData(list);
        return MyResultUtils.success(list);
    }

    /**
     * 数据导入excel表格然后下载（带title）
     *
     * @param response
     * @param title
     * @return
     */
    @GetMapping("/export")
    public void exportData(@RequestParam("title") String[] title,
                           HttpServletResponse response) {
        personService.exportData(response, title);
    }

    /**
     * 导入excel
     *
     * @param response
     */
    @GetMapping("/excel")
    public void excelData(HttpServletResponse response) {
        personService.excelData(response);
    }


    @PostMapping("/import")
    public void importData(MultipartFile file) {
        personService.importData(file);
    }

    @GetMapping("/updateSecond")
    public MyResult updateSecond(Integer integer) {
        personService.updateSecond(integer);
        return MyResultUtils.success();
    }

    /**
     * @MethodName: getCount
     * @Param [name]
     * @Return com.example.demo.model.MyResult
     * @Description:
     * @author: zhongbo
     * @date: 2020/6/28 19:21
     */
    @GetMapping("/getCount")
    public MyResult getCount(@RequestParam("name") String name) {
       Integer integer= personService.getCount(name);
        return MyResultUtils.success(integer);
    }

}
