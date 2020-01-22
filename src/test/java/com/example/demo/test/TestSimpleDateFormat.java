package com.example.demo.test;



import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author:zhongbo
 * @Description: SimpleDateFormat的使用
 * @date:  2020/1/19 16:39
 */
public class TestSimpleDateFormat {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("date 1= " + date);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("format = " + format);


    }
}
