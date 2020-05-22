package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private int id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private List<String> courseNames;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
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
}


