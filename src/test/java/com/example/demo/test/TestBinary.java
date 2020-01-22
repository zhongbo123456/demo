package com.example.demo.test;
/**
 * @author:zhongbo
 * @Description: 输入int变量返回二进制（toBinaryString），八进制（toOctalString），十六进制的字符串（toHexString）
 * @date:  2020/1/14 17:58
 */
public class TestBinary {
    public static void main(String[] args) {
        //此方法返回int变量的二进制表示的字符串
        String s = Integer.toBinaryString(2);
        System.out.println("s = " + s);
        //s = 10

        //分别返回int变量的16进制表示
        String s1 = Integer.toHexString(15);
        System.out.println("s1 = " + s1);
        //s1 = f

        //分别返回int变量的8进制表示
        String s2 = Integer.toOctalString(10);
        System.out.println("s2 = " + s2);
        //s2 = 12

    }
}
