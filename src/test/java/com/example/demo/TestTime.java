package com.example.demo;

import org.junit.jupiter.api.Test;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo
 * @Description: 时间戳转字符串
 * @Author: zhongbo
 * @Date: 2020/4/7 18:36
 */
public class TestTime {
    @Test
    public void test1() {
        String deviceName="aljajdflsjdlj";
        long time1 = 1585552165;
        long time2=1585804825;
        String startTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date(time1 * 1000));
        String endTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date(time2 * 1000));
        System.out.println("10位数的时间戳（秒）--->Date:" + startTime);
        System.out.println("10位数的时间戳（秒）--->Date:" + endTime);
        String s = deviceName +"-" +startTime +"-"+ endTime + ".xlsx";
        System.out.println(s);
        StringBuilder stringBuilder=new StringBuilder();
        StringBuilder append = stringBuilder.append(deviceName).append("-").append(startTime).append("-").append(endTime).append(".xlsx");
        System.out.println(append);
    }
}
