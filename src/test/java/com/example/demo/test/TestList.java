package com.example.demo.test;

        import java.util.ArrayList;
        import java.util.List;
/**
 * @author:zhongbo
 * @Description: 测试集合retainAll方法，两个集合取交集
 * @date:  2020/1/7 17:03
 */
public class TestList {
    public static void main(String[] args) {
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        list1.add("zhangsan");
        list1.add("lisi");
        list1.add("wangwu");
        list1.add("zhaosi");
        list1.add("tianqi");

        list2.add("tianqi");
        list2.add("dehua");
        list2.add("zhangsan");

        list1.retainAll(list2);
        System.out.println("list1 = " + list1);
        //结果：list1 = [zhangsan, tianqi]
        list2.retainAll(list1);
        System.out.println("list2 = " + list2);
        //结果：list2 = [tianqi, zhangsan]

        List<Long> roles2=new ArrayList<>();
        roles2.add(5L);
        List<Long> roles4=new ArrayList<>();
        roles4.add(5L);
        List<Long> roles3=new ArrayList<>();
        roles2.retainAll(roles3);
        System.out.println("roles2 = " + roles2);
        //roles2 = []
        roles4.removeAll(roles2);
        System.out.println("roles4 = " + roles4);
        //roles4 = [5]

    }
}
