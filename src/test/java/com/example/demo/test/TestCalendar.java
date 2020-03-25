package com.example.demo.test;

import java.util.Calendar;

public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);

    }
}
