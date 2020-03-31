package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.model.MyResult;
import com.example.demo.service.MongoDBService;
import com.example.demo.utils.MyResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.controller
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/3/30 17:39
 */
@RestController
@RequestMapping("/mongoDB")
public class MongoDBController {
    @Autowired
    MongoDBService mongoDBService;
    @GetMapping("/getAll")
    public MyResult getAll(){
        List<Course> list = mongoDBService.getAll();
        return MyResultUtils.success(list);
    }
    @PutMapping("/update")
    public MyResult update(Course course){
        MyResult result= mongoDBService.update(course);
        return MyResultUtils.success(result);
    }
    @DeleteMapping("/delete")
    public MyResult delete(String name){
        mongoDBService.delete(name);
        return MyResultUtils.success();
    }

}
