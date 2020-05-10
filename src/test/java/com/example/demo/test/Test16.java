package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/6 15:11
 */
public class Test16 {
    @Test
    public void test1(){
        List<Map<String, Long>> list = Test16.getperHourInterval(null);
        list.forEach(stringLongMap -> {
            Long startTime = stringLongMap.get("start");
            Long endTime = stringLongMap.get("end");
            Date sTime=new Date(startTime);
            Date eTime=new Date(endTime);
            System.out.println("sTime:"+sTime);
            System.out.println("eTime:"+eTime);

        });
        System.out.println(list.size());
    }
    /**
     * 获得当天每小时的开始时间戳，结束时间戳
     * @return
     */
    public static List<Map<String, Long>> getperHourInterval(String s) {
        List<Map<String,Long>> list=new ArrayList<>();
        Long yesterday23Hour = Test16.getTodayTimeInterval(23, "yesterday");
        Long yesterday24Hour = Test16.getDayEndTime("yesterday");
        Map<String,Long> yesterdayHour=new HashMap<>();
        yesterdayHour.put("start",yesterday23Hour);
        yesterdayHour.put("end",yesterday24Hour);
        list.add(yesterdayHour);
        for (int i = 0; i <23; i++) {
            Map<String,Long> map=new HashMap<>();
            Long zeroTime= Test16.getTodayTimeInterval(i,s);
            Long oneTime= Test16.getTodayTimeInterval((i+1),s);
            map.put("start",zeroTime);
            map.put("end",oneTime);
            list.add(map);
        }
        Map<String,Long> map=new HashMap<>();
        Map<String, Long> stringLongMap = list.get(list.size() - 1);
        map.put("start",stringLongMap.get("end"));
        map.put("end", Test16.getDayEndTime(s));
        list.add(map);
        return list;
    }
    /**
     * 获得指定小时的时间戳
     * @param i
     * @return
     */
    public static Long getTodayTimeInterval(int i,String s){
        Calendar calendar = Calendar.getInstance();
        if("yesterday".equalsIgnoreCase(s)){
            calendar.add(Calendar.DATE,-1);
        }
        calendar.set(Calendar.HOUR_OF_DAY, i);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long time = calendar.getTimeInMillis();
        return time;
    }


    /**
     * 获取当天的结束时间戳
     * @return
     */
    public static Long getDayEndTime(String s){
        Calendar calendar = Calendar.getInstance();
        if("yesterday".equalsIgnoreCase(s)){
            calendar.add(Calendar.DATE,-1);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 99);
        long time = calendar.getTimeInMillis();
        return time;
    }
}
