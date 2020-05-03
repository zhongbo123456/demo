package com.example.demo.test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/3 20:52
 */
public class TestAnnotation {

    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> testAnnotationClass = TestAnnotation.class;
        Method show = testAnnotationClass.getMethod("show");
        MyAnnotation[] annotationsByType = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotationsByType) {
            System.out.println("myAnnotation = " + myAnnotation.value());
        }
    }

    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show(){

    }
}
