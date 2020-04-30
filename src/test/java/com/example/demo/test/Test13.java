package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/27 14:58
 */
public class Test13 {
    @Test
    public void test1(){
        List<Map<String,Long>> list=new ArrayList<>();
        for (int i = 0; i <23; i++) {
            Map<String,Long> map=new HashMap<>();
            Long zeroTime= getTodayTimeInterval(i);
            Long oneTime=getTodayTimeInterval(i+1);
            map.put("start",zeroTime);
            map.put("end",oneTime);
            list.add(map);
        }
        Map<String,Long> map=new HashMap<>();
        Map<String, Long> stringLongMap = list.get(list.size() - 1);
        map.put("start",stringLongMap.get("end"));
        map.put("end",getDayEndTime());
        list.add(map);



    }
    public static Long getTodayTimeInterval(int i){
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, i);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        Long time = todayStart.getTimeInMillis();
        return time;
    }


    /**
     * 获取当天的结束时间戳
     * @return
     */
    public static Long getDayEndTime(){
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 99);
        long time = todayEnd.getTimeInMillis();
        return time;
    }

    /**
     * Collectors.summarizingDouble
     */
    @Test
    public void test2(){
        List<Student> list=new ArrayList<>();
        Student student=new Student("a1",2.0);
        Student student1=new Student("a2",3.0);
        Student student2=new Student("a3",3.0);
        Student student3=new Student("a4",4.0);
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        DoubleSummaryStatistics collect = list.stream().collect(Collectors.summarizingDouble(Student::getHeight));
        double sum = collect.getSum();
        System.out.println(sum);
    }

    @Test
    public void test3(){
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());
        System.out.println(instance);

    }

    /**
     * Calendar
     */
    @Test
    public void test4(){
        Long yesterday = getTodayTimeInterval(0,null);
    }

    public static Long getTodayTimeInterval(int i,String s){
        Calendar calendar = Calendar.getInstance();
        if("yesterday".equalsIgnoreCase(s)){
            calendar.add(Calendar.DATE,-1);
        }
        calendar.set(Calendar.HOUR_OF_DAY, i);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        System.out.println(calendar.getTime());
        Long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * reduce
     */
    @Test
    public void test5(){
        Student student1=new Student(2,2);//0
        Student student2=new Student(1,3);//2
        Student student3=new Student(1,4);//3
        Student student4=new Student(1,5);//4
        Student student5=new Student(1,6);//5
        Student student6=new Student(1,7);//6
        List<Student> list=new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        Optional<Integer> reduce = list.stream().map(student -> student.getAge() - student.getId()).reduce((x, y) -> x + y);
        System.out.println(reduce.get());


    }

}
