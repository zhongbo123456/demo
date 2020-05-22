package com.example.demo.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.entity
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/20 15:12
 */
@Component
public class TestPersonBean {
    /**
     * Spring的@Bean注解用于告诉方法，产生一个Bean对象，
     * 然后这个Bean对象交给Spring管理。产生这个Bean对象的方法Spring只会调用一次，
     * 随后这个Spring将会将这个Bean对象放在自己的IOC容器中。
     *
     * name指定bean名字，不指定默认方法名createBean
     */
    @Bean(name = "aa")
    public static PersonBean createBean(){
        PersonBean personBean=new PersonBean();
        personBean.setName("zhaoliu");
        return personBean;
    }
}
