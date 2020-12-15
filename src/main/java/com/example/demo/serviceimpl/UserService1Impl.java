package com.example.demo.serviceimpl;

import com.example.demo.service.UserService1;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.serviceimpl
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/12/15 22:53
 */
@Service
public class UserService1Impl implements UserService1 {
    @Async
    @Override
    public void hadle1() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\"处理结束\" = " + "处理结束");
    }
}
