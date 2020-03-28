package com.example.demo.test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class TestTime {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2018,2,27);
        long millis = calendar.getTimeInMillis()+8*60*60*1000;
        System.out.println(millis);
        String deviceName="zz";
        List<String> list = Arrays.asList(deviceName);
        list.stream().forEach(s -> System.out.print(s));


    }


}
