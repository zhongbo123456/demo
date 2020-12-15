package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.boot.test.json.JsonbTester;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/6/30 20:07
 */
public class Test20 {
    @Test
    public void test1(){
        String s="[11,12]";
        List<Long> longs = JSON.parseArray(s, Long.class);
    }

    /**
     * String.format()
     */
    @Test
    public void  test2(){
        double s=12.5675;
        String format = String.format("%.2f", s);
        System.out.println(format);

    }

    /**
     *  Integer.bitCount()
     */
    @Test
    public void test3(){
        System.out.println(Integer.bitCount(3));
        System.out.println(Integer.bitCount(10));
        System.out.println(Integer.bitCount(150));

        System.out.println(Long.bitCount(0));


        System.out.println(Long.bitCount(10));
    }
    @Test
    public void test4(){
        Alarm alarm1=new Alarm("110","A");
        Alarm alarm2=new Alarm("111","A");
        Alarm alarm3=new Alarm("1","A");
        Alarm alarm4=new Alarm("110","B");
        Alarm alarm5=new Alarm("111","B");
        Alarm alarm6=new Alarm("1","B");
        List<Alarm> data=new ArrayList<>();
        data.add(alarm1);
        data.add(alarm2);
        data.add(alarm3);
        data.add(alarm4);
        data.add(alarm5);
        data.add(alarm6);
        System.out.println(JSON.toJSONString(data));
        // 4.查询出来的结果集 将errorNum作为key 设备名作为值存入map中
        Map<String, List<String>> map = new HashMap<>(16);
        for (Alarm alarmInfo : data) {
            // 4.1获取报警码alarmCode
            String alarmCode = alarmInfo.getAlarmCode();
            // 4.2根据报警码获取设备名集合
            List<String> list = map.get(alarmCode);
            // 4.3如果集合不存在代表是该map一次都没有存储数据   集合存在则继续添加设备名至map的值中
            if (list == null || list.size() == 0) {
                list = new ArrayList<>();
                list.add(alarmInfo.getDeviceName());
                map.put(alarmInfo.getAlarmCode(), list);
            } else {
                list.add(alarmInfo.getDeviceName());
                map.put(alarmInfo.getAlarmCode(), list);
            }
        }
        // 5.定义返回的结果集合
        List<Alarm> resultList = new ArrayList<>();
        // 6.遍历map集合将对应报警码下的对应设备数量统计
        System.out.println(map.keySet());
        for (String alarmCode : map.keySet()) {
            Alarm alarmInfo = new Alarm();
            alarmInfo.setAlarmCode(alarmCode);
            alarmInfo.setDeviceCount(map.get(alarmCode).size());
            resultList.add(alarmInfo);
        }
        System.out.println(JSON.toJSONString(resultList));


    }
    @Test
    public void test5(){
        Map<String, List<String>> map = new HashMap<>();
        List<String> list1=new ArrayList<>();
        list1.add("A");
        map.put("110",list1);

        List<String> list2=new ArrayList<>();
        list2.add("A");
        list2.add("B");
        map.put("110",list2);
        System.out.println(JSON.toJSONString(map));

    }

    /**
     * Collections.sort()方法和流中排序方法
     */
    @Test
    public void test6(){
        List<String> list = Arrays.asList("data2_admin");
        list.stream().forEach(s -> {
            System.out.println("s = " + s);
        });
        System.out.println("JSON.toJSONString(list) = " + JSON.toJSONString(list));

        List<String> list1 = Arrays.asList("d", "c", "b", "a");
        System.out.println("JSON.toJSONString(list1) before= " + JSON.toJSONString(list1));

        List<String> collect1 = list1.stream().sorted().collect(Collectors.toList());
        System.out.println("JSON.toJSONString(collect1) stream= " + JSON.toJSONString(collect1));

        Collections.sort(list1);
        System.out.println("JSON.toJSONString(list1) after= " + JSON.toJSONString(list1));

        List<Integer> integers = Arrays.asList(4, 5, 9, 7, 2, 0);
        List<Integer> collect = integers.stream().sorted().collect(Collectors.toList());
        System.out.println("JSON.toJSONString(collect) stream= " + JSON.toJSONString(collect));
        System.out.println("JSON.toJSONString(integers) before= " + JSON.toJSONString(integers));
        Collections.sort(integers);
        System.out.println("JSON.toJSONString(integers) after= " + JSON.toJSONString(integers));


    }


}
