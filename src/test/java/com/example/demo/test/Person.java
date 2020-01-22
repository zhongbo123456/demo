package com.example.demo.test;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * @author:zhongbo
 * @Description: person序列化时指定MySerializer中序列化方式
 * @date:  2020/1/15 17:44
 */
@JsonSerialize(using =MySerializer.class )
public class Person {
    private String name;
    private  int age;
    private String address;

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
