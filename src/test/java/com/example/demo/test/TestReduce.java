package com.example.demo.test;

        import org.junit.jupiter.api.Test;

        import java.util.Arrays;
        import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/4/23 22:37
 */
public class TestReduce {
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("sum = " + sum);
    }
}
