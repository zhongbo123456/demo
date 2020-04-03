package com.example.demo.serviceimpl;

import com.example.demo.entity.Course;
import com.example.demo.entity.Course1;
import com.example.demo.model.MyResult;
import com.example.demo.service.MongoDBService;
import com.example.demo.utils.MyResultUtils;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(criteria)
               /* ,
                Aggregation.group("price")
                .sum("price").as("value")*/
                //Aggregation.project("price")

        );
        AggregationResults<Course> aggregate = mongoTemplate.aggregate(aggregation, COLLECTION_NAME, Course.class);
        List<Course> list = aggregate.getMappedResults();
        return list;
    }

    @Override
    public MyResult update(Course course) {
        Criteria criteria = Criteria.where("name").is(course.getName());
        Update update = Update.update("price", course.getPrice());
        UpdateResult upsert = mongoTemplate.upsert(Query.query(criteria), update, COLLECTION_NAME);
        return MyResultUtils.success(upsert);
    }

    @Override
    public void delete(String name) {
        Criteria criteria = Criteria.where("name").is(name);
        DeleteResult remove = mongoTemplate.remove(Query.query(criteria), COLLECTION_NAME);
    }
}
