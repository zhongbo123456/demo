package com.example.demo.test;


import com.alibaba.fastjson.JSONObject;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/10 17:55
 */
public class TestJsonString {
    public static void main(String[]args){
        String s="{\"name\":\"zhangsan\", \"age\":20, \"address\":\"路\"}";
        String s1="nisi";

                if( TestJsonString.checkJSONString(s1)){
                    System.out.println("success");
                }else {
                    System.out.println("error");
                }

    }
    public static boolean checkJSONString(String s){
        JSONObject jsonObject = null;
        try {
            jsonObject = JSONObject.parseObject(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
