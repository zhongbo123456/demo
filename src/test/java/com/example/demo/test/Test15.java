package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/3 9:51
 */
public class Test15 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.9, Employee.Status.FREE),
            new Employee("李四", 30, 5555.5, Employee.Status.BUSY),
            new Employee("王五", 40, 6666.6, Employee.Status.VOCATION),
            new Employee("赵六", 50, 7777.7, Employee.Status.FREE),
            new Employee("田七", 60, 8888.8, Employee.Status.BUSY),
            new Employee("田七", 60, 8888.8, Employee.Status.BUSY)
    );

    @Test
    public void test1() {
        //Collectors.toList()转list集合
        List<Integer> collect = employees.stream().map(employee -> employee.getAge()).collect(Collectors.toList());
        System.out.println("collect = " + collect);

        //Collectors.toSet() 转set集合
        Set<Integer> collect1 = employees.stream().map(employee -> employee.getAge()).collect(Collectors.toSet());
        System.out.println("collect1 = " + collect1);

        //Collectors.counting() 总数
        Long collect2 = employees.stream().collect(Collectors.counting());
        System.out.println("collect2 = " + collect2);

        //Collectors.averagingDouble() 平均值
        Double collect3 = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("collect3 = " + collect3);

        // Collectors.summingDouble() 总和
        Double collect4 = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("collect4 = " + collect4);

        //Collectors.maxBy()最大值
        Optional<Employee> collect5 = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("collect5 = " + collect5.get());

        //Collectors.minBy()最小值
        Optional<Employee> collect6 = employees.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("collect6.get() = " + collect6.get());

        //Collectors.partitioningBy()分区--符合条件一个区，不符合条件一个区
        Map<Boolean, List<Employee>> collect7 = employees.stream().distinct().collect(Collectors.partitioningBy(employee -> employee.getSalary() > 7000));
        System.out.println("collect7 = " + collect7);

        //Collectors.groupingBy()分组，也可以多级分组
        Map<Employee.Status, List<Employee>> collect8 = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println("collect8 = " + collect8);
        Map<Employee.Status, Map<String, List<Employee>>> collect9 = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (((Employee) e).getAge() <= 35) {
                return "青年";

            } else if (((Employee) e).getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        })));
        System.out.println("collect9 = " + collect9);
        //Collectors.summarizingDouble()--可以求平均值，总和，最大值，最小值等
        DoubleSummaryStatistics collect10 = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("collect10.getSum() = " + collect10.getSum());
        System.out.println("collect10.getAverage() = " + collect10.getAverage());
        //Collectors.joining()连接
        String collect11 = employees.stream().map(employee -> employee.getName()).distinct().collect(Collectors.joining(","));
        System.out.println("collect11 = " + collect11);

    }
    @Test
    public void test2(){
        Instant start = Instant.now();
        LongStream.rangeClosed(0,100000000000L)
                .parallel().reduce(0,Long::sum);
        Instant end = Instant.now();
        System.out.println("Duration.between(start,end).toMillis() = " + Duration.between(start, end).toMillis());//18237
    }

    /**
     * LocalDate,LocalTime,LocalDateTime
     */
    @Test
    public void test3(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime of = LocalDateTime.of(2015, 10, 10, 12, 22, 33);
        System.out.println("of = " + of);
        LocalDateTime localDateTime = now.plusYears(2);
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("now.getYear() = " + now.getYear());
        System.out.println("now.getMonthValue() = " + now.getMonthValue());
        System.out.println("now.getDayOfMonth() = " + now.getDayOfMonth());
        System.out.println("now.getSecond() = " + now.getSecond());


    }
    /**
     * Instant
     */
    @Test
    public void test4(){
        Instant now = Instant.now();//默认获取UTC时区
        System.out.println("now = " + now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);
        //时间戳
        System.out.println("now.toEpochMilli() = " + now.toEpochMilli());
        //加1分种
        Instant instant = Instant.ofEpochSecond(60);
        System.out.println("instant = " + instant);
    }
    /**
     * Duration:计算两个“时间”之间的间隔
     *
     */
    @Test
    public  void test5(){
        Instant now = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println("between.toMillis() = " + between.toMillis());
    }

    /**
     * Period:计算两个“日期”之间的间隔
     */
    @Test
    public void test6(){
        LocalDate of = LocalDate.of(2015, 1, 1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        LocalDate now = LocalDate.now();
        Period between = Period.between(of, now);
        System.out.println("between = " + between);
        System.out.println("between.getYears() = " + between.getYears());
        System.out.println("between.getMonths() = " + between.getMonths());
        System.out.println("between.getDays() = " + between.getDays());

    }

    /**
     * TemporalAdjuster:时间校正器
     */
    @Test
    public void test7(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        //指定日期
        LocalDateTime localDateTime = now.withDayOfMonth(1);
        System.out.println("localDateTime = " + localDateTime);
        //下个周六
        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("with = " + with);

        //自定义下个工作日
        LocalDateTime with1 = now.with((l) -> {
            LocalDateTime ldt = (LocalDateTime) l;
            DayOfWeek dayOfWeek = ldt.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(1);
            }

        });
        System.out.println("with1 = " + with1);
    }

    /**
     * DateTimeFormatter:格式化时间/日期
     */
    @Test
    public void test8(){
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(isoDate);
        System.out.println("format = " + format);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format1 = dateTimeFormatter.format(now);
        System.out.println("format1 = " + format1);
        LocalDateTime parse = now.parse(format1,dateTimeFormatter);
        System.out.println("parse = " + parse);

    }

    /**
     * 时区
     */
    @Test
    public void test9(){
        //获得所有时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("availableZoneIds = " + availableZoneIds);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Europe/Lisbon"));
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Europe/Lisbon"));
        System.out.println("zonedDateTime = " + zonedDateTime);
    }
}
