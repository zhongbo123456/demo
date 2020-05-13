package com.example.demo.test;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;
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

    /**
     * map
     */
    @Test
    public void test3(){
        Map<String,Integer> map1=new HashMap<>();
        map1.put("zhangsan",20);
        map1.put("lisi",21);
        map1.put("wangwu",22);
        map1.put("zhaoliu",20);
        System.out.println("map1:"+map1);

        Map<String,Integer> map2=new HashMap<>();
        map2.put("aa",100);
        map2.put("bb",50);
        System.out.println("map2:"+map2);
        //从指定映射中将所有映射关系复制到此映射中。
        map1.putAll(map2);
        System.out.println(map1);
        // remove() 删除关联对象，指定key对象
        map1.remove("zhaoliu");
        System.out.println("使用remove："+map1);
        // clear() 清空集合对象
        map2.clear();
        System.out.println("使用clear："+map2);
        //get()
        System.out.println(map1.get("aa"));
        //size()
        System.out.println(map1.size());
        // boolean isEmpty() 长度为0返回true否则false
        System.out.println(map1.isEmpty());
        // boolean containsKey(Object key) 判断集合中是否包含指定的key
        System.out.println(map1.containsKey("aa"));
        // boolean containsValue(Object value)
        System.out.println(map1.containsValue(100));
        //键变量
        for (String s : map1.keySet()) {
            System.out.println(s);
        }
     System.out.println();
        //值遍历
        for (Integer value : map1.values()) {
            System.out.println(value);
        }
        System.out.println();
        //键值对遍历
        for (Map.Entry<String, Integer> stringIntegerEntry : map1.entrySet()) {
            System.out.println(stringIntegerEntry.getKey());
            System.out.println(stringIntegerEntry.getValue());
        }
        //treeMap
        //TreeMap中的元素默认按照keys的自然排序排列。
        //（对Integer来说，其自然排序就是数字的升序；对String来说，其自然排序就是按照字母表排序）
        //TreeMap(Comparator comparator)：创建一个空TreeMap，按照指定的comparator排序
        Map<Integer,String> map3=new TreeMap<>(Comparator.reverseOrder());
        map3.put(1,"ee");
        map3.put(2,"dd");
        map3.put(3,"cc");
        map3.put(4,"bb");
        map3.put(5,"aa");
        for (Map.Entry<Integer, String> integerStringEntry : map3.entrySet()) {
            System.out.println(integerStringEntry.getKey() + "," + integerStringEntry.getValue());
        }

    }
}
