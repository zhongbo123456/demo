package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BatchRequest;
import com.example.demo.entity.User;
import com.example.demo.model.MyResult;
import com.example.demo.service.UserService;
import com.example.demo.utils.MyResultUtils;

/**
 * @ClassName: com.example.demo.controller.UserController.java
 * @Description:
 * @author: zhongbo
 * @date: 2020-01-22 17:41
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/testAsyn")
    public MyResult testAsyn() {
        BatchRequest batchRequest = userService.testAsyn();
        return MyResultUtils.success(batchRequest);
    }

    @GetMapping("/select")
    public MyResult selectUserMessage(@RequestParam("userId") Long userId){
        User user= userService.selectUserMessage(userId);
        return MyResultUtils.success(user);
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public MyResult login(String username, String password) {
        MyResult result = new MyResult();
        User user = userService.login(username, password);
        if (user != null) {
            result.setCode(0);
               result.setMsg("登录成功");
            result.setObj(user);
        } else {
            result.setCode(1);
            result.setMsg("登录失败");
            result.setObj(null);

        }
        return result;

    }
}
