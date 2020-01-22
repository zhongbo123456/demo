package com.example.demo.test;

import java.text.DecimalFormat;

public class TestAppend {
    public static void main(String[] args) {
        String s="204";
        int i = Integer.parseInt(s);
        i+=1;
        DecimalFormat mFormat = new DecimalFormat("000");
        String format = mFormat.format(i);
        System.out.println("format = " + format);
    }
}
