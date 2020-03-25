package com.example.demo.test;

import java.text.DecimalFormat;

public class TestAppend {
    public static void main(String[] args) {
        String s="204";
        String buildingId="00000A";
        System.out.println(buildingId);
        int i = Integer.parseInt(s);
        i+=1;
        DecimalFormat mFormat = new DecimalFormat("000");
        String s1 = buildingId + mFormat.format(i);
        System.out.println("format = " + s1);
    }
}
