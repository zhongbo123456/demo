package com.example.demo.test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/11 13:40
 */
public class Test17 {
    /**
     * 判断对象属性是否都为null
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        Student student=new Student(1,null);
        if(isAllFieldNull(student)){
            System.out.println("student的属性都为空");
        }else {
            System.out.println("student的属性不都为空");
        }
        Person person=new Person();
        if(isFieldNUll(person)){
            System.out.println("person的属性都为空");
        }else {
            System.out.println("person的属性不都为空");
        }


    }

    /**
     * 判断该对象是否
     * 限制：对象里的属性都以包装类定义
     */

    public static boolean isAllFieldNull(Object obj) throws Exception{
        Class stuCla = (Class) obj.getClass();// 得到类对象
        Field[] fs = stuCla.getDeclaredFields();//得到属性集合
        boolean flag = true;
        for (Field f : fs) {//遍历属性
            f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
            Object val = f.get(obj);// 得到此属性的值
            if(val!=null) {//只要有1个属性不为空,那么就不是所有的属性值都为空
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * java8不能使用continue和break
     * java8中使用return跳出本次循环进行下次循环
     */
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(integer -> {
            if (integer==3){
                return;
            }
            System.out.print(integer+",");
        });
    }

    public static Boolean isFieldNUll(Object obj){
        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        AtomicReference<Boolean> flag= new AtomicReference<>(true);
        Arrays.stream(declaredFields).forEach(field -> {
            field.setAccessible(true);
            try {
                Object o = field.get(obj);
                if(o!=null){
                    flag.set(false);
                    return;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        });
        return flag.get();
    }
}
