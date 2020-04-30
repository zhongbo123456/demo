package com.example.demo.test;

public class Student {
    private  int id;
    private Integer age;
    private String address;
    private Double height;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
