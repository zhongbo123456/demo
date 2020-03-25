package com.example.demo.test;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSplict {
    public static void main(String[] args) {
        String s="12:20-13:30";
        Integer startHour;
        Integer startMinture;
        Integer endHour;
        Integer endMinture;
        String[] split = s.split("-");
        System.out.println(split[0]);
        String[] split1 = split[0].split(":");
        startHour=Integer.parseInt(split1[0]);
        startMinture=Integer.parseInt(split1[1]);
        System.out.println("startHour:"+startHour);
        System.out.println("startMinture:"+startMinture);
        System.out.println(split[1]);
        String[] split2 = split[1].split(":");
        endHour=Integer.parseInt(split2[0]);
        endMinture=Integer.parseInt(split2[1]);
        System.out.println("endHour:"+endHour);
        System.out.println("endMinture:"+endMinture);

       /* SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));*/
        long time = new Date().getTime();
        System.out.println(time);
        long l = time / 1000;
        System.out.println(l);
        System.out.println(System.currentTimeMillis() / 1000);

    }
}
