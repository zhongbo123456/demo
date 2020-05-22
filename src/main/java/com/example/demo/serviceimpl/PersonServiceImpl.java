package com.example.demo.serviceimpl;

import com.example.demo.entity.Student;
import com.example.demo.entity.Student1;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;
    @Override
    public Student selectById(int id) {
        Student student = personMapper.selectById(id);
        return student;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> list=personMapper.selectAll();
        return list;
    }

    @Override
    public Student update(Student student) {
        personMapper.update(student);
        Student student1 = selectById(student.getId());
        return student1;
    }

    @Override
    public List<Student1> getData(List<Student1> list) {
        List<Student1> list1 = personMapper.getData(list);
        list.stream().forEach(s->{
            list1.stream().forEach(student3 -> {
                if(s.getsName().equals(student3.getsName())){
                    s.setAge(student3.getAge());
                    s.setAddress(student3.getAddress());
                    s.setSex(student3.getSex());
                }
            });
        });
        return list1;
    }
}
