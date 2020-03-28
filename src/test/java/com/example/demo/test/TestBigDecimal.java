package com.example.demo.test;

import java.math.BigDecimal;
import java.util.Date;

public class TestBigDecimal {
    public static void main(String[] args) {
        Object o=21.1f;
        Object o1=22.5f;
        String format = String.format("%1.2f", o);
        String format1=String.format("%1.2f",o1);
        BigDecimal bigDecimal=new BigDecimal(format);
        BigDecimal bigDecimal1=new BigDecimal(format1);
        double v = bigDecimal.add(bigDecimal1).doubleValue();
        System.out.println("v:"+v);

        Integer i=20;
        Double aDouble = Double.valueOf(i.toString());
        System.out.println("aDouble:"+aDouble);
        double v1 = Double.parseDouble(i.toString());
        System.out.println("v1:"+v1);

        long time = new Date().getTime();
        System.out.println(time);
    }

}
