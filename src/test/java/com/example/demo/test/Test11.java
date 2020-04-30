package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/24 9:13
 */
public class Test11 {
    @Test
    public void test1(){
        Student student1=new Student(1,"a");
        Student student2=new Student(2,"a");
        Student student3=new Student(3,"a");
        Student student4=new Student(4,"a");
        List<Student> list=new ArrayList<>();
        list.add(student4);
        list.add(student3);
        list.add(student2);
        list.add(student1);
        System.out.println(list.toString());
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
       list.forEach(student -> {
           list1.add(student.getId());
       });
        System.out.println("list1:"+list1.toString());

        list.stream().forEach(student -> {
            list2.add(student.getId());
        });
        System.out.println("list2:"+list2.toString());
        list.stream().map(student -> student.getId()).sorted().forEach(System.out::println);
        List<Integer> integers = Arrays.asList(4,3,2,1);
        System.out.println("_______________");
        integers.stream().sorted(Integer::compareTo).forEach(System.out::println);


    }
    @Test
    public void test2(){
        //reduce 一个参数，运算
        System.out.println(Stream.of(1,2, 3, 4,5).reduce((x, y) -> x + y));
        //reduce 二个参数，初始值，运算
        System.out.println(Stream.of(1, 2, 3, 4).reduce(5, (x, y) -> x + y));
        System.out.println(Stream.of(1,2, 3, 4, 5, 6,7,8,9).reduce((x, y) -> x + y));
        System.out.println((32 * 38));//1216
        System.out.println((32 * 72));//
    }

    @Test
    public void test3(){
        String s2 ="a_2";
        String s1 ="b_1";
        String s3="c_3";
        String s4="d_4";
        List<String> list = new ArrayList<>();
        list.add(s2);
        list.add(s1);
        list.add(s4);
        list.add(s3);
        System.out.println("list:"+list.toString());
        //把list里按照_后面的1，2，3，4排列，结果为[b_1, a_2, c_3, d_4]
        if(list.get(0).contains("_")){
            StringSort("_",list);

        }

    }

    public void StringSort(String s,List<String> list){
            List<String> collect1 = list.stream().sorted((x, y) -> {
                String a1 = x.substring(x.lastIndexOf(s)+1) ;
                String a2 = y.substring(y.lastIndexOf(s)+1) ;
                return a1.compareTo(a2);
            }).collect(Collectors.toList());
            System.out.println("collect1:"+collect1);


    }
    @Test
    public void test4(){
        Student student=null;
        //1大括号没省略
        if(student==null){
            student=new Student(1,2,"文化路");
            System.out.println(student.toString());
        }
        //2省略大括号
        if(student==null) student=new Student(2,2,"aa");
        System.out.println(student.toString());
    }
    @Test
    public void test5(){
        //2020-04-20 09:16:48毫秒值的时间戳1587345408000
        Date startTime=new Date(1587345408000L);
        System.out.println("startTime:"+startTime);
        //2020-04-30 09:16:48毫秒值时间戳1588209408000
        Date endTime=new Date(1588209408000L);
        System.out.println("endTime:"+endTime);
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        String format = sdw.format(startTime);
        System.out.println("fromat:"+format);
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        System.out.println("time:"+time);
        calendar.setTime(startTime);
        System.out.println(calendar.getTime());
        long timeInMillis = calendar.getTimeInMillis();
        System.out.println("timeInMillis:"+timeInMillis);
        if(startTime.getTime()<endTime.getTime()){
            //日期加一，例如20号，输出21号
            //calendar.add(Calendar.DAY_OF_YEAR,1);
            //System.out.println(calendar.getTime());
            //月份加1，例如4月，输出5月
            calendar.add(Calendar.MONDAY,1);
            System.out.println(calendar.getTime());
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            System.out.println("1:"+calendar.getTime());
            calendar.add(Calendar.DATE, -1);
            System.out.println("2:"+calendar.getTime());
            calendar.set(Calendar.HOUR_OF_DAY, 13);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            System.out.println("3:"+calendar.getTime());


        }


    }

    @Test
    public void test6(){
        Student s=new Student(1,20,"文化路");
        Optional<Student> optional = Optional.of(s);
        Student student1 = optional.orElse(null);
        System.out.println(student1);
        Student s1=null;
        Optional<Student> option2 = Optional.ofNullable(s1);
        Student student2 = option2.orElse(null);
        System.out.println(student2);
        Student student = option2.orElseGet(() -> new Student(1, 20, "aa"));
        System.out.println(student);
        optional.ifPresent(student3 -> System.out.println(student3.getAddress()));
        option2.ifPresent(student3 -> System.out.println(student3.getAddress()));

        String unkown = optional.map(student3 -> student3.getAddress()).orElse("unkown");
        System.out.println(unkown);
        String aDefault = option2.map(student3 -> student3.getAddress()).orElse("default");
        System.out.println(aDefault);

        Student student3=new Student(1,2,"香樟路");
        List<String> list=new ArrayList<>();
        list.add("187310");
        list.add("1457822");
        student3.setPhones(list);
        List<String> list1 = Optional.of(student3).flatMap(u -> Optional.ofNullable(u.getPhones())).orElse(Collections.emptyList());
        System.out.println(list.isEmpty());



    }

    /**
     * flatmap
     */
    @Test
    public void test7(){
        List<String> list1 = Arrays.asList("aa", "bb", "cc");
        List<String> list2 = Arrays.asList("dd", "ee", "ff");
        List<List<String>> totalList=new ArrayList<>();
        totalList.add(list1);
        totalList.add(list2);
        System.out.println("totalList:"+totalList);//totalList:[[aa, bb, cc], [dd, ee, ff]]
        //before java8
        List<String> tempList=new ArrayList<>();
        for (List<String> list : totalList) {
            for (String s : list) {
                tempList.add(s);
            }
        }
        System.out.println("tempList"+tempList);//tempList[aa, bb, cc, dd, ee, ff]
        //java8
        List<String> collect = totalList.stream().flatMap(plist -> plist.stream()).collect(Collectors.toList());
        System.out.println("collect"+collect);//collect[aa, bb, cc, dd, ee, ff]
    }
    @Test
    public void test8(){
        Long startTime1=1588232783000L;//2020-04-30 15:46:23
        Long endTime2=1588250783000L;//2020-04-30 20:46:23
        Date startTime=new Date(startTime1);
        Date endTime=new Date(endTime2);

        List<Long> startTimeList=new ArrayList<>();
        List<Long> endTimeList=new ArrayList<>();
        List<Date> startTimeDateList=new ArrayList<>();
        List<Date> endTimeDateList=new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        System.out.println("1:"+calendar.getTime());
        startTimeDateList.add(calendar.getTime());
        while(calendar.getTimeInMillis()<endTime2){
            calendar.add(Calendar.HOUR_OF_DAY,1);
            System.out.println("2:"+calendar.getTime());
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND,0);
            System.out.println("3:"+calendar.getTime());
            startTimeDateList.add(calendar.getTime());
        }
        System.out.println(startTimeDateList);
    }



}
