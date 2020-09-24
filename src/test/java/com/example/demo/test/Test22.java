package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.DeviceErrorNumber;
import com.example.demo.entity.Student2;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/8/12 13:11
 */
public class Test22 {
    @Test
    public void test1(){
        DeviceErrorNumber deviceErrorNumber4=new DeviceErrorNumber("009569060000007f","202");

        DeviceErrorNumber deviceErrorNumber1=new DeviceErrorNumber("0095690C0000006C","202");
        DeviceErrorNumber deviceErrorNumber2=new DeviceErrorNumber("00956906000004a7","202");
        DeviceErrorNumber deviceErrorNumber3=new DeviceErrorNumber("009569060000049c","202");
        DeviceErrorNumber deviceErrorNumber5=new DeviceErrorNumber("b4e62d9ef831","202");
        DeviceErrorNumber deviceErrorNumber6=new DeviceErrorNumber("f8cf273f3a88a257","202");
        DeviceErrorNumber deviceErrorNumber7=new DeviceErrorNumber("a4cf127cb6b0","202");
        DeviceErrorNumber deviceErrorNumber8=new DeviceErrorNumber("00956906000004a4","202");
        DeviceErrorNumber deviceErrorNumber9=new DeviceErrorNumber("a4cf12771b48","202");
        DeviceErrorNumber deviceErrorNumber10=new DeviceErrorNumber("0095690C0000006D","202");



        DeviceErrorNumber deviceErrorNumber14=new DeviceErrorNumber("00956906000004a3","203");
        DeviceErrorNumber deviceErrorNumber16=new DeviceErrorNumber("0095690600000498","203");
        DeviceErrorNumber deviceErrorNumber21=new DeviceErrorNumber("0095690C00000050","203");

        DeviceErrorNumber deviceErrorNumber11=new DeviceErrorNumber("0095690C0000006C","203");
        DeviceErrorNumber deviceErrorNumber12=new DeviceErrorNumber("00956906000004a7","203");
        DeviceErrorNumber deviceErrorNumber13=new DeviceErrorNumber("b4e62d9ef831","203");
        DeviceErrorNumber deviceErrorNumber15=new DeviceErrorNumber("0095690C0000006D","203");
        DeviceErrorNumber deviceErrorNumber17=new DeviceErrorNumber("009569060000049c","203");
        DeviceErrorNumber deviceErrorNumber18=new DeviceErrorNumber("a4cf127cb6b0","203");
        DeviceErrorNumber deviceErrorNumber19=new DeviceErrorNumber("f8cf273f3a88a257","203");
        DeviceErrorNumber deviceErrorNumber20=new DeviceErrorNumber("a4cf12771b48","203");
        DeviceErrorNumber deviceErrorNumber22=new DeviceErrorNumber("00956906000004a4","203");

        DeviceErrorNumber deviceErrorNumber23=new DeviceErrorNumber("0095690C0000006C","104");
        DeviceErrorNumber deviceErrorNumber24=new DeviceErrorNumber("0095690C0000006C","200");
        DeviceErrorNumber deviceErrorNumber25=new DeviceErrorNumber("0095690C0000006C","32");

        DeviceErrorNumber deviceErrorNumber26=new DeviceErrorNumber("00956906000004a7","32");
        DeviceErrorNumber deviceErrorNumber27=new DeviceErrorNumber("00956906000004a7","200");
        DeviceErrorNumber deviceErrorNumber28=new DeviceErrorNumber("00956906000004a7","103");
        List<DeviceErrorNumber> list=new ArrayList<>();
        list.add(deviceErrorNumber1);
        list.add(deviceErrorNumber2);
        list.add(deviceErrorNumber3);
        list.add(deviceErrorNumber4);
        list.add(deviceErrorNumber5);
        list.add(deviceErrorNumber6);
        list.add(deviceErrorNumber7);
        list.add(deviceErrorNumber8);
        list.add(deviceErrorNumber9);
        list.add(deviceErrorNumber10);

        list.add(deviceErrorNumber11);
        list.add(deviceErrorNumber12);
        list.add(deviceErrorNumber13);
        list.add(deviceErrorNumber14);
        list.add(deviceErrorNumber15);
        list.add(deviceErrorNumber16);
        list.add(deviceErrorNumber17);
        list.add(deviceErrorNumber18);
        list.add(deviceErrorNumber19);
        list.add(deviceErrorNumber20);
        list.add(deviceErrorNumber21);
        list.add(deviceErrorNumber22);

        list.add(deviceErrorNumber23);
        list.add(deviceErrorNumber24);
        list.add(deviceErrorNumber25);
        list.add(deviceErrorNumber26);
        list.add(deviceErrorNumber27);
        list.add(deviceErrorNumber28);


        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(DeviceErrorNumber::getErrorNum, Collectors.counting()));
        System.out.println(JSON.toJSONString(collect));
        //方式一
       /* List<DeviceErrorNumber> collect1 = list.stream()
                .filter(deviceErrorNumber -> deviceErrorNumber.getErrorNum().equals("202") || deviceErrorNumber.getErrorNum().equals("203"))
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect1));
        System.out.println(collect1.size());*/



        List<String> errorNums=new ArrayList<>();
        errorNums.add("202");
        errorNums.add("203");
        //方式二
       /* List<DeviceErrorNumber> collect2 = list.stream().filter(d -> errorNums.contains(d.getErrorNum())).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect2));
        System.out.println(collect2.size());*/
        //方式三
        Map<Boolean, List<DeviceErrorNumber>> collect3 = list.stream().collect(Collectors.partitioningBy(deviceErrorNumber -> errorNums.contains(deviceErrorNumber.getErrorNum())));
        List<DeviceErrorNumber> aTrue = collect3.get(true);
        System.out.println("aTrue:"+JSON.toJSONString(aTrue)+":"+aTrue.size());
        List<DeviceErrorNumber> aFalse = collect3.get(false);
        System.out.println("aFalse:"+ JSON.toJSONString(aFalse)+":"+aFalse.size());
        Map<String, Long> collect1 = aFalse.stream().collect(Collectors.groupingBy(DeviceErrorNumber::getErrorNum, Collectors.counting()));

        Map<String, List<DeviceErrorNumber>> collect2 = aTrue.stream().collect(Collectors.groupingBy(DeviceErrorNumber::getDeviceName));
        System.out.println(collect2.size());
        collect1.put(StringUtils.join(errorNums),Long.valueOf(collect2.size()));


        List<String> error2=new ArrayList<>();
        error2.add("200");
        error2.add("32");
       /* List<DeviceErrorNumber> collect4 = list.stream()
                .filter(deviceErrorNumber -> error2.contains(deviceErrorNumber.getErrorNum())).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect4));
        Map<String, List<DeviceErrorNumber>> collect5 = collect4.stream().collect(Collectors.groupingBy(DeviceErrorNumber::getDeviceName));*/

        Map<String, List<DeviceErrorNumber>> collect6 = list.stream()
                .filter(deviceErrorNumber -> error2.contains(deviceErrorNumber.getErrorNum()))
                .collect(Collectors.groupingBy(DeviceErrorNumber::getDeviceName));
        collect1.put(StringUtils.join(error2),Long.valueOf(collect6.size()));
        long count = list.stream()
                .filter(deviceErrorNumber -> error2.contains(deviceErrorNumber.getErrorNum())).map(deviceErrorNumber -> deviceErrorNumber.getDeviceName()).distinct().count();
        System.out.println(count);
        System.out.println("collect1:"+JSON.toJSONString(collect1));


    }





    @Test
    public void test2() throws ParseException {
        String s="12:00-13:30,12:00-13:30,11:00-12:00,09:20-08:30,10:00-10:00";
        String[] split1 = s.split(",");
        System.out.println("split1:"+Arrays.toString(split1));
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
        for (int i = 0; i < split1.length; i++) {
            String[] split = split1[i].split("-");
            Date begin = simpleDateFormat.parse(split[0]);
            System.out.println("begin:"+begin);
            Date end = simpleDateFormat.parse(split[1]);
            System.out.println("end:"+end);
            System.out.println("result:"+begin.before(end)+":"+i);
            if(!begin.before(end)){
                System.out.println("第" + (i + 1) + "次时间选择不正确，开始时间不能小于结束时间");
            }
        }

        List<String> list = Arrays.asList(split1);
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println("collect:"+collect);
        String join = StringUtils.join(collect, ",");
        System.out.println(join);





    }

    @Test
    public void test3() throws ParseException {
        String [] s={"12:00-13:30","12:00-13:30","11:00-12:00","09:20-08:30","10:00-10:00"};
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
        System.out.println("s:"+Arrays.toString(s));
        for (int i = 0; i < s.length; i++) {
            String[] split = s[i].split("-");
            Date begin = simpleDateFormat.parse(split[0]);
            System.out.println("begin:"+begin);
            Date end = simpleDateFormat.parse(split[1]);
            System.out.println("end:"+end);
            System.out.println("result:"+begin.before(end)+":"+i);
            if(!begin.before(end)){
                System.out.println("第" + (i + 1) + "次时间选择不正确，开始时间不能小于结束时间");
            }
        }
        List<String> list = Arrays.asList(s);
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println("collect:"+collect);
        String join = StringUtils.join(collect, ",");
        System.out.println(join);
    }

    /**
     * list集合复制
     */
    @Test
    public void test4(){
        int count=3;
        List<Integer> countList=new ArrayList<>();
        countList.add(1);
        countList.add(2);
        List<Integer> list=new ArrayList<>(count);
        System.out.println(list.toString());
        List<Integer> list1=new ArrayList<>(countList);
        System.out.println(list1.toString());
        Error error=new Error();
        error.setErrorList(list);

        list.add(1);




    }

    /**
     * Base64进行编码和解码
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test5() throws UnsupportedEncodingException {
        String s="123456";
        byte[] bytes = s.getBytes("UTF-8");
        //编码
        String string = Base64.getEncoder().encodeToString(bytes);
        System.out.println(string);
        //解码
        byte[] decode = Base64.getDecoder().decode(string);
        String s1 = new String(decode, "UTF-8");
        System.out.println(s1);
    }
    @Test
    public void test6(){

        BigDecimal bSubtracted = new BigDecimal(String.valueOf(144914.3));
        BigDecimal bSubtraction = new BigDecimal(String.valueOf(141914.4));
        double v = bSubtracted.subtract(bSubtraction).doubleValue();

    }

    @Test
    public void test7(){
        String config="[123456]";
        System.out.println(config.length());
        System.out.println(config.substring(0, 7));
        System.out.println(config.indexOf("[") + 1);
        System.out.println(config.lastIndexOf("]"));

        if (config.contains("[")&&config.contains("]")){
            int begin = config.indexOf("[") + 1;
            int end = config.lastIndexOf("]");
            config = config.substring(begin, end);
            System.out.println(config);
        }else {
            config="";
        }
    }

    @Test
    public void test8(){
        List<Long> list=new ArrayList<>();
        list.add(1L);
        list.add(2L);
        System.out.println("clear before:"+JSON.toJSONString(list));
        list.clear();
        System.out.println("clear after:"+JSON.toJSONString(list));
    }

    /**
     * 获取当前时间戳的方式
     */
    @Test
    public void test9(){
        String s = UUID.randomUUID().toString();
        System.out.println(s);
        System.out.println(s.length());

        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(new Date().getTime()/1000);
        System.out.println(Calendar.getInstance().getTimeInMillis() / 1000);
        System.out.println(Instant.now().toEpochMilli() / 1000);
        System.out.println(Timestamp.valueOf(LocalDateTime.now()).getTime() / 1000);
    }

    @Test
    public void test10(){
        Date date = new Date(1598507471000L);
        System.out.println("date = " + date);
        Long reportTime=1598507471L;
        Calendar instance = Calendar.getInstance();
        System.out.println("instance.getTimeInMillis() = " + instance.getTimeInMillis()/1000);
        instance.add(Calendar.MINUTE,30);
        long l = instance.getTimeInMillis() / 1000;
        System.out.println("l = " + l);
        if(reportTime>l){
            System.out.println("\"上报时间戳有错误\" = " + "上报时间戳有错误");
        }
        else {
            System.out.println("\"ok\" = " + "ok");
        }


    }

    @Test
    public void test11(){
        Double parentValue=10.0;
        Double childValue=40.0;
        double v = (parentValue - childValue) / parentValue * 100;
        String s=v+"%";
        System.out.println("s = " + s);
        double d=33.38333333;
        System.out.println("String.format(\"%.2f\", d) = " + String.format("%.2f", d));
        System.out.println("0.0/10.0*100 = " + 0.0 / 10.0 * 100);
    }

    @Test
    public void test12(){
        String unitStr="{\"name\":\"zhangsan\",\"age\":1}";
        List<String> unitList = new ArrayList<>();
        if (StringUtils.isNotBlank(unitStr)) {

            if (unitStr.contains(",")) {
                unitList = Arrays.asList(unitStr.split(","));
            }else {
                unitList.add(unitStr);
            }
            System.out.println("JSON.toJSONString(unitList) = " + JSON.toJSONString(unitList));
            System.out.println("unitList.get(0) = " + unitList.get(0));

        }else {
            System.out.println("JSON.toJSONString(unitList) = " + JSON.toJSONString(unitList));
        }

    }

    /**
     *对象不为空，值为空，不会报空指针
     */
    @Test
    public void test13(){
        Student student=new Student();
        student.setAddress("zz");
        Person person=new Person();
        person.setAddress(student.getAddress());
        System.out.println("student.getAge() = " + student.getAge());
        person.setAge(student.getAge());
        System.out.println("JSON.toJSONString(person) = " + JSON.toJSONString(person));
    }

    /**
     * 37.4-null
     */
    @Test
    public void test14(){
        Float f=37.4f;
        Student2 student2=new Student2();
        student2.setName("z");
        System.out.println("student2.getValue() = " + student2.getValue());
        float v = f - student2.getValue();
        System.out.println("v = " + v);

    }

    
}
