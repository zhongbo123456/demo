package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.model.MyResult;
import com.example.demo.service.MongoDBService;
import com.example.demo.utils.MyResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
