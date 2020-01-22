package com.example.demo.entity;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Student {
    @NotNull(message = "传入的值是空，请传值")
    private int id;
    @NotNull(message = "name传入的值是空，请传值")
    @org.apache.bval.constraints.NotEmpty(message = "name传入的值不能是空字符串")
    private String name;
    @Min(1)
    @Max(20)
    @NotNull(message = "age传入的值是空，请传值")
    private Integer age;

    @NotNull(message = "sex传入的值是空，请传值")
    private String sex;


    @NotNull(message = "address传入的值是空，请传值")
    private String address;
}


