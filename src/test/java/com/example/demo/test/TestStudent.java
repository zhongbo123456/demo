package com.example.demo.test;

public class TestStudent {
    public static void main(String[] args) {
        Student s=new Student(1,"文化路");
        Student student=new Student(2,15,"路");
        Integer age = s.getAge();
        System.out.println("age = " + age);
        //s.setAge(age);
        System.out.println("s = " + s);
        Integer age1 = student.getAge();
        System.out.println("age1 = " + age1);
        System.out.println("student = " + student);

        Float f= Float.valueOf(1);
        Float f1=1f;
        System.out.println("f = " + f);
        System.out.println("f1 = " + f1);
        double d=0.00;
        if(d>0){
            System.out.println( true);

        }else {
            System.out.println( false);
        }
        //false



    }


}
