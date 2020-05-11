package com.example.demo.test;

import com.example.demo.entity.Address;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseRepository;
import com.example.demo.service.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.example.demo.entity.Person;
import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.test
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/9 13:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MongodbTest {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    private static final String COLLECTION_NAME="person";

    @Test
    public void test1(){
        courseRepository.save(new Course("pe",200));
        courseRepository.save(new Course("music",200));
        courseRepository.save(new Course("physical",200));
        courseRepository.save(new Course("Chemistry",200));
        courseRepository.save(new Course("pe",200));
        List<Course> all = courseRepository.findAll();
        System.out.println(all.toString());

    }
    @Test
    public void test2(){
        List<Course> allByPrice = courseRepository.findAllByPrice(100);
        System.out.println(allByPrice.toString());
        List<Course> pe = courseRepository.findByName("pe");
        System.out.println(pe.toString());

    }

    @Test
    public void test3(){
        Address address1=new Address("浙江省","杭州市","滨江区");
        Address address2=new Address("浙江省","杭州市","江干区");
        Address address3=new Address("浙江省","杭州市","余杭区");
        Person person1=new Person("李四",21,0,address1);
        Person person2=new Person("王五",22,1,address2);
        Person person3=new Person("赵六",23,0,address3);
        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        List<Person> all = personRepository.findAll();
        System.out.println(all.toString());
    }
    @Test
    public void test4(){
        List<Person> bySex = personRepository.findBySex(0);
        System.out.println(bySex.toString());
    }

    @Test
    public void test5(){
        Criteria criteria = Criteria.where("sex").is(0).and("address.province").is("浙江省")
                .and("address.city").is("杭州市");

        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.match(criteria),
                Aggregation.group("address.province","address.city")
        );
        AggregationResults<Person> aggregate = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Person.class);
        List<Person> mappedResults = aggregate.getMappedResults();
        System.out.println(mappedResults.toString());
    }
}
