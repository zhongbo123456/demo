package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
/**
 * @author:zhongbo
 * @Description: 枚举类的values方法
 * @date:  2020/1/10 10:43
 */
public class TestDemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for (SerachName value : SerachName.values()) {
            list.add(value.getValue());
        }
        System.out.println("list = " + list);
        //list = [张三, 李四, 王五]
        String str="2as34s3d1w34";
        System.out.println(str);
        //replace支持字符串替换
        System.out.println(str.replace("4","z"));
        //replace支持字符替换
        System.out.println(str.replace('4', 'z'));
        /*正则表达式\d  是匹配一个数字(0到9)
            \\d 前面多了第一个\ 是为了在程序中转义第二个\，这个你可以忽略*/
        System.out.println(str.replaceAll("\\d","g"));
        System.out.println(str.replaceAll("4", "z"));
        //将第一次出现的4换成z
        System.out.println(str.replaceFirst("4", "z"));
        System.out.println("##################################################");
        String s="012";
        //一个参数表示从起始下标到字符串长度末尾
        System.out.println("s.substring(0) = " + s.substring(0));
        //返回字符串的子串，两个参数返回起始下标到结束的子串，左包含右不包含
        System.out.println("s.substring(0,2) = " + s.substring(0, 2));
        System.out.println("##################################################");


        //基本类型--》String
        int i=170;
        //字符串拼接
        String s1=i+"";
        System.out.println("s1 = " + s1);
        //静态valueOf方法
        String s2 = String.valueOf(i);
        System.out.println("s2 = " + s2);
        // 此方法返回的字符串表示的无符号整数参数所表示的值以十六进制（基数为16）
        String s4 = Integer.toHexString(i);
        System.out.println("s4 = " + s4);

        //String--》基本类型
        String s3="170";
        int i1 = Integer.parseInt(s3);
        System.out.println("i1 = " + i1);

        String s5 = Integer.toHexString(15);
        System.out.println(s5);
        System.out.println("s5.length() = " + s5.length());
        if (s5.length() % 2 != 0) {
            s5 = "0" + s5;
        }
        System.out.println("s5 = " + s5);

        System.out.println("Math.pow(2,1) = " + Math.pow(2, 2));
        //Math.pow(2,1) = 4.0
        Integer integer=new Integer(1);
        int i2 = integer.intValue();


    }
}
