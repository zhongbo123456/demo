package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;

public class TestLocalDate {
    /**
     * Instant——它代表的是时间戳
     * LocalDate——不包含具体时间的日期，比如2014-01-14。它可以用来存储生日，周年纪念日，入职日期等。
     * LocalTime——它代表的是不含日期的时间
     * LocalDateTime——它包含了日期及时间，不过还是没有偏移信息或者说时区。
     * ZonedDateTime——这是一个包含时区的完整的日期时间，偏移量是以UTC/格林威治时间为基准的。
     */
    @Test
    public void test1() {
        //获取当前日期
        LocalDate today = LocalDate.now();
        System.out.println(today);//2020-04-09
        //获取当前年月日
        System.out.println("年："+today.getYear());//年：2020
        System.out.println("月："+today.getMonthValue());//月：4
        System.out.println(today.getMonth());//APRIL
        System.out.println("日："+today.getDayOfMonth());//日：9
        //获得某一特定时间的日期
        System.out.println("获得某一特定时间的日期:"+LocalDate.of(2018, 2, 15));
        /**
         *  如何在java中判断是否是某个节日或者重复事件，
         *  使用MonthDay类。这个类由月日组合，不包含年信息，
         *  可以用来代表每年重复出现的一些日期或其他组合
         */
        LocalDate dateofBirth = LocalDate.of(1995, 4, 14);
        LocalDate now = LocalDate.now();
        MonthDay birthday = MonthDay.of(dateofBirth.getMonthValue(), dateofBirth.getDayOfMonth());
        MonthDay currentMonthAndDay = MonthDay.from(now);
        if(currentMonthAndDay.equals(birthday)){
            System.out.println("today is my birthday");
        }else {
            System.out.println("today is not my birthday");
        }

        //获得当前时间,默认的格式是hh:mm:ss:nnn
        System.out.println(LocalTime.now());//17:29:56.320
        //增加时间里面的小时数
        LocalTime now1 = LocalTime.now();
        System.out.println(now1.plusHours(2));//19:31:57.909
        //如何获取1周后的日期
        System.out.println("当前日期："+today);//当前日期：2020-04-09
        System.out.println("一周后日期："+today.plus(1, ChronoUnit.WEEKS));//一周后日期：2020-04-16
        System.out.println("一年前的日期："+today.minus(1, ChronoUnit.YEARS));//一年前的日期：2019-04-09
        System.out.println("一年后的日期："+today.plus(1, ChronoUnit.YEARS));//一年后的日期：2021-04-09

        //在java8中使用时钟
        System.out.println(Clock.systemUTC());//SystemClock[Z]
        System.out.println(Clock.systemDefaultZone());//SystemClock[Asia/Shanghai]

        //在java中如何判断某个日期在另一个日期的前面还是后面
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println("后一天日期："+tomorrow);
        System.out.println("today是在tomorrow之前吗？"+today.isBefore(tomorrow));//true
        System.out.println("today是在tomorrow之后吗？"+today.isAfter(tomorrow));//false


    }
}
