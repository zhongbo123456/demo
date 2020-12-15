package com.example.demo.serviceimpl;

import com.example.demo.entity.BatchRequest;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService1 userService1;
    @Override
    public User login(String username, String password) {
       User user= userMapper.login(username,password);

        return user;
    }

    @Override
    public BatchRequest testAsyn() {
        BatchRequest batchRequest=this.createBatchRequest();
        //this.handle(batchRequest);
        userService1.hadle1();
        return batchRequest;
    }



    @Override
    @Async
    public void handle(BatchRequest batchRequest) {
        try {
            Thread.sleep(1000*60*1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\"处理结束\" = " + "处理结束");


    }


    private BatchRequest createBatchRequest() {
        BatchRequest batchRequest=new BatchRequest();
        batchRequest.setUserId(1L);
        batchRequest.setComplete(false);
        return batchRequest;
    }
}
