package com.example.demo.common;




/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.common
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/22 17:57
 */
public class MyException  extends RuntimeException{
    private Integer code;
    public MyException(String message,Integer code){
        super(message);
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
