package com.example.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/6/3 18:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Test
    public void test1(){
        ValueOperations<String, String> redis = redisTemplate.opsForValue();
        String age = redis.get("age");
        System.out.println(age);
    }
}
