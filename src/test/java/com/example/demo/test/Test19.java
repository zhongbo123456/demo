package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import com.example.demo.entity.Student;

import java.util.*;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/6/18 16:31
 */
public class Test19 {
    @Test
    public void test1(){
        Student student=new Student();
        System.out.println(student.getName());
    }
    @Test
    public void test2(){
        String phone="+86-18738106325";
        String[] s = phone.split("-");
        for (String s1 : s) {
            System.out.println(s1);
        }
        System.out.println(s[1]);
    }

    @Test
    public void test3(){
        Object o=1.0f;
        Float o1 = (Float) o;
        System.out.println(o1);
    }
    @Test
    public void test4(){
        //声明一个数组
        String[] str = new String[]{"08:20-09:30", "09:30-10:30", "18:00-19:00"};
        String join = StringUtils.join(str, ",");
        System.out.println(join);
      /*  //创建一个StringBuffer的对象
        StringBuffer str2 = new StringBuffer();
        //循环遍历数组
        for (int i = 0; i < str.length; i++) {
            //用append()方法拼接
            str2.append(str[i] + ",");
        }
        //用substring()方法截取掉最后一个 ","
        String str3 = str2.substring(0, str2.length() - 1);
        //输出拼接好的字符串
        System.out.println(str3);*/
    }

    /**
     * json格式取出字符串数组
     */
    @Test
    public void test5(){
        String s="{\n" +
                "\"seconds\":1,\n" +
                "\"splices\":1,\n" +
                "\"peakQuantile\":1,\n" +
                "\"fftLenVib\":1,\n" +
                "\"fftLenAudio\":1,\n" +
                "\"maxFreq\":1,\n" +
                "\"decimateFactorVib\":1,\n" +
                "\"decimateFactorAudio\":1,\n" +
                "\"spcTimeWindow\":1,\n" +
                "\"spcSubgroup\":1,\n" +
                "\"interval\":30,\n" +
                "\"hourMinute\":[\"08:20-09:30\",\"10:00-11:20\"]\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(s);
        Integer machineType = jsonObject.getObject("machineType", Integer.class);
        System.out.println(machineType);
        Integer fftLenAudio = jsonObject.getObject("fftLenAudio", Integer.class);
        System.out.println(fftLenAudio);

        Float peakQuantile = jsonObject.getObject("peakQuantile", Float.class);
        System.out.println(peakQuantile);
        String[] hourMinutes = jsonObject.getObject("hourMinute", String[].class);
        int length = hourMinutes.length;
        System.out.println("length:"+length);
        for (String hourMinute : hourMinutes) {
            System.out.println(hourMinute);
        }
    }
    @Test
    public void test6(){
        String s="abcd-efg-opt";
        String replace = s.replace("-", ",");
        System.out.println(replace);
        List<String> list=new ArrayList<>();
        list.add("aa-bb");
        list.add("cc-dd");
        list.add("ee-ff");
        List<String> list1=new ArrayList<>();
         list.forEach(s1 -> {
            String replace1 = s1.replace("-", ",");
            list1.add(replace1);
        });

        System.out.println(JSON.toJSONString(list1));
    }

    @Test
    public void test7(){
        Object o=new Object();
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(o));
        Double max = jsonObject.getObject("value", Double.class);
        if(max==null){
            max=0d;
        }
        System.out.println(max);
        Object o1=new Object();
        JSONObject jsonObject1 = JSON.parseObject(JSON.toJSONString(o));
        Double min = jsonObject1.getObject("value", Double.class);
        if(min==null){
            min=0d;
        }
        System.out.println(min);
        Map<String, Double> map = new HashMap();
        map.put("max", max);
        map.put("min", min);
        map.put("increase", max - min);
        System.out.println(JSON.toJSONString(map));

    }

    /**
     * @MethodName:  test8
     * @Param []
     * @Return void
     * @Description: 类对象的三种创建方式
     * @author: zhongbo
     * @date:  2020/6/29 20:27
     */
    @Test
    public void test8() throws NoSuchFieldException, ClassNotFoundException {
        //类名.class
        Class<Student> studentClass = Student.class;
        String name = studentClass.getName();
        System.out.println(name);
        //对象名.getClass()
        Student student=new Student();
        Class<? extends Student> aClass = student.getClass();
        String name1 = aClass.getName();
        System.out.println(name1);
        //Class.forName("类的全路径")
        Class<?> aClass1 = Class.forName("com.example.demo.entity.Student");
        String name2 = aClass1.getName();
        System.out.println(name2);
    }

}
