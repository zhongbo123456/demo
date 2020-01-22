package com.example.demo.test;

public enum SerachName {
    ZHANGSAN("张三"),
    LISI("李四"),
    WANGWU("王五");


    private String value;

    SerachName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
