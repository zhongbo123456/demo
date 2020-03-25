package com.example.demo.test;

public class Test3 {
    public static void main(String[] args) {
       /* byte [] content={1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};
        System.out.println("content.length:"+content.length);
        byte[] result = null;
        if (content.length % 16 != 0) {
            result = new byte[16 - content.length % 16 + content.length];
            byte[] b1 = "################".getBytes();
            for (byte b2:b1) {
                System.out.println("b2 = " + b2);
            }
            System.arraycopy(content, 0, result, 0, content.length);
            System.arraycopy(b1, 0, result, content.length, 16 - content.length % 16);
            for (byte b:result) {
                System.out.println("b = " + b);
            }
        }*/
        byte[] bytes = "123456789".getBytes();
        for (byte b3 : bytes) {
            System.out.println("b3 = " + b3);

        }

    }
}
