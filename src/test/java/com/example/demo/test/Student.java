package com.example.demo.test;

import lombok.Data;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.List;
@Data
public class Student {
    private Integer id;
    private Integer age;
    private String address;
    private Double height;
    List<String> phones;

    public Student() {
    }

    public Student(String address, Double height) {
        this.address = address;
        this.height = height;
    }

    public Student(Integer id, Integer age, String address, Double height) {
        this.id = id;
        this.age = age;
        this.address = address;
        this.height = height;
    }

    public Student(Integer id, Integer age, String address) {
        this.id = id;
        this.age = age;
        this.address = address;
    }

    public Student(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
