package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;


public class Test5 {
    public static void main(String[] args) {
     List<DeviceOnlineNum> onlineList=new ArrayList<>();
        DeviceOnlineNum d1= new DeviceOnlineNum();
        d1.setUseCode(1);
        d1.setOnlineNum(19);
        DeviceOnlineNum d2= new DeviceOnlineNum();
        d2.setUseCode(2);
        d2.setOnlineNum(18);
        DeviceOnlineNum d3= new DeviceOnlineNum();
        d3.setUseCode(3);
        d3.setOnlineNum(17);
        DeviceOnlineNum d4= new DeviceOnlineNum();
        d4.setUseCode(4);
        d4.setOnlineNum(16);
        onlineList.add(d1);
        onlineList.add(d2);
        onlineList.add(d3);
        onlineList.add(d4);

        for (DeviceOnlineNum deviceOnlineNum : onlineList) {
            System.out.println("online:"+deviceOnlineNum.toString());
        }
        System.out.println("**************************");

        List<DeviceOnlineNum> totalList=new ArrayList<>();
        DeviceOnlineNum c1= new DeviceOnlineNum();
        c1.setUseCode(1);
        c1.setTotal(20);
        DeviceOnlineNum c2= new DeviceOnlineNum();
        c2.setUseCode(2);
        c2.setTotal(20);
        DeviceOnlineNum c3= new DeviceOnlineNum();
        c3.setUseCode(3);
        c3.setTotal(20);
        DeviceOnlineNum c4= new DeviceOnlineNum();
        c4.setUseCode(4);
        c4.setTotal(20);
        totalList.add(c1);
        totalList.add(c2);
        totalList.add(c3);
        totalList.add(c4);

        for (DeviceOnlineNum deviceOnlineNum : totalList) {
            System.out.println("total:"+deviceOnlineNum.toString());

        }

        System.out.println("-----------------------------------");

        List<DeviceOnlineNum> list=new ArrayList<>();

        for (DeviceOnlineNum onlineNum : onlineList) {
            for (DeviceOnlineNum totalNum : totalList) {
                if(totalNum.getUseCode().equals(onlineNum.getUseCode())){
                    onlineNum.setTotal(totalNum.getTotal());
                    list.add(onlineNum);
                }
            }

        }

        for (DeviceOnlineNum deviceOnlineNum : list) {
            System.out.println("success:"+deviceOnlineNum.toString());
        }



    }
}
