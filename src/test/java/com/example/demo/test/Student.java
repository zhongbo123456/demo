package com.example.demo.test;

import lombok.Data;

import java.util.List;
@Data
public class Student {
    private  int id;
    private Integer age;
    private String address;
    private Double height;
    List<String> phones;

    public Student(String address, Double height) {
        this.address = address;
        this.height = height;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Student() {
    }

    public Student(int id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public Student(int id, String address) {
        this.id = id;
        this.address = address;
    }

    public Student(int id, Integer age, String address) {
        this.id = id;
        this.age = age;
        this.address = address;
    }

}
