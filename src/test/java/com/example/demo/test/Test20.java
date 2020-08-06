package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/6/30 20:07
 */
public class Test20 {
    @Test
    public void test1(){
        String s="[11,12]";
        List<Long> longs = JSON.parseArray(s, Long.class);
    }

    /**
     * String.format()
     */
    @Test
    public void  test2(){
        double s=12.5675;
        String format = String.format("%.2f", s);
        System.out.println(format);

    }

    /**
     *  Integer.bitCount()
     */
    @Test
    public void test3(){
        System.out.println(Integer.bitCount(3));
        System.out.println(Integer.bitCount(10));
        System.out.println(Integer.bitCount(150));

        System.out.println(Long.bitCount(0));


        System.out.println(Long.bitCount(10));
    }

}
