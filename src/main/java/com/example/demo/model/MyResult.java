package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyResult<T> implements Serializable {
    private int code;
    private String msg;
    private T obj;

}
