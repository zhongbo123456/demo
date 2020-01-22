package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.MyResult;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET )
    public MyResult login(String username,String password){
        MyResult result=new MyResult();
        User user=userService.login(username,password);
        if(user!=null){
            result.setCode(0);
            result.setMsg("登录成功");
            result.setObj(user);
        }else {
            result.setCode(1);
            result.setMsg("登录失败");
            result.setObj(null);

        }
        return result;

    }
}
