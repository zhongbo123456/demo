package com.example.demo.serviceimpl;

import com.example.demo.entity.Course;
import com.example.demo.service.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.serviceimpl
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/3/31 15:56
 */
@Service
public class MongoDBServiceImpl implements MongoDBService {
    private static final String COLLECTION_NAME = "course";
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<Course> getAll() {
        Criteria criteria=Criteria.where("price").gte(0);
        Aggregation aggregation = Aggregation.newAggregation(Course.class,
                Aggregation.match(criteria),
                Aggregation.group("name")
                        .sum("price").as("price")

        );
        AggregationResults<Course> aggregate = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Course.class);
        List<Course> list = aggregate.getMappedResults();
        return list;
    }
}
