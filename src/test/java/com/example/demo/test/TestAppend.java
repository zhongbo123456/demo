package com.example.demo.test;

import java.text.DecimalFormat;

public class TestAppend {
    public static void main(String[] args) {
     /*   String s="204";
        String buildingId="00000A";
        System.out.println(buildingId);
        int i = Integer.parseInt(s);
        i+=1;
        DecimalFormat mFormat = new DecimalFormat("000");
        String s1 = buildingId + mFormat.format(i);
        System.out.println("format = " + s1);*/

       /*
       \t 相当于tab，缩进
        \n 回车
        \r 换行
        */
       String [] s={"户号","表身号","地址","Meter Code"};
       StringBuilder sb=new StringBuilder();
      /*  for (String s1 : s) {
            sb.append(s1).append("\t");
        }
        System.out.println(sb);*/
        for (int i = 0; i < s.length; i++) {
            switch (s[i]){
                case "户号":
                case "Meter Code":
                    System.out.println("1");
                break;
                case "表身号":System.out.println("表身号");
                break;
                default:
                    break;
            }
        }

    }
}
