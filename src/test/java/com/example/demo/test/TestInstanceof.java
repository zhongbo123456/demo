package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

public class TestInstanceof {
    public static void main(String[] args) {
        //boolean result = obj instanceof Class
        //1.obj必须为引用类型，不能是基本类型,只能用作对象的判断
        int i = 1;
        //System.out.println("(i instanceof Integer) = " + (i instanceof Integer));//编译不通过

        //2.在 JavaSE规范 中对 instanceof 运算符的规定就是：如果 obj 为 null，那么将返回 false。
        System.out.println("(null instanceof  Object) = " + (null instanceof Object));//false
        //3.obj为class类的实例对象
        Integer integer = new Integer(1);
        System.out.println("(integer instanceof Object) = " + (integer instanceof Object));//true

        //4.obj为class接口的实现类
        ArrayList arrayList=new ArrayList();
        System.out.println("(arrayList instanceof List) = " + (arrayList instanceof List));//true

        //5.obj为class类的直接或间接子类
        Animal animal=new Animal();
        Animal a=new Dog();
        Dog dog=new Dog();
        System.out.println("(animal instanceof dog) = " + (animal instanceof Dog));//false
        System.out.println("(a instanceof Dog) = " + (a instanceof Dog));//true
        System.out.println("(dog instanceof Dog) = " + (dog instanceof Dog));//true

    }


}
class Animal{}
class Dog extends Animal{}