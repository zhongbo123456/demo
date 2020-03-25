package com.example.demo.test;



public class Test2 {
    public static void main(String []args){
        int a=15;
        String s = Integer.toHexString(a);
        System.out.println("s = " + s);
        System.out.println("s.length() = " + s.length());
        if (s.length() % 2 != 0) {
            s = "0" + s;
        }
        System.out.println(s);


    }

    }
