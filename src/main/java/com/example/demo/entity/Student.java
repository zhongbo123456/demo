package com.example.demo.entity;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;


public class Student {
    private int id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private List<String> courseNames;

    public Student() {
    }

    public Student(int id, Integer age, String address) {
        this.id = id;
        this.age = age;
        this.address = address;
    }

    public Student(int id, String address) {
        this.id = id;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getCourseNames() {
        return courseNames;
    }

    public void setCourseNames(List<String> courseNames) {
        this.courseNames = courseNames;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", courseNames=" + courseNames +
                '}';
    }
}


