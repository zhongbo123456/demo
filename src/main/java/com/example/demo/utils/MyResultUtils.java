package com.example.demo.utils;

import com.example.demo.model.MyResult;

public class MyResultUtils {
    public static MyResult success(Object data){
        MyResult result=new MyResult();
        result.setCode(1);
        result.setMsg("成功");
        result.setObj(data);
        return result;
    }
    public static MyResult success(){
        MyResult result=new MyResult();
        result.setCode(1);
        result.setMsg("成功");
        result.setObj(null);
        return result;
    }

    public static MyResult fail(){
        MyResult result=new MyResult();
        result.setCode(0);
        result.setMsg("失败");
        result.setObj(null);
        return result;
    }
}
