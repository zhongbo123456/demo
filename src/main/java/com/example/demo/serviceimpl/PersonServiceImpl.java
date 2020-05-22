package com.example.demo.serviceimpl;

import com.example.demo.entity.Student;
import com.example.demo.entity.Student1;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.PersonService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

    @Override
    public void exportData(HttpServletResponse response,String[]title) {
       List<Student> list=personMapper.queryData();
       //设置相应内容为二进制流
        response.setContentType("application/octet-stream");
        try {
            String fileName = System.currentTimeMillis() + "." + "xlsx";
            response.setHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes(StandardCharsets.UTF_8),StandardCharsets.ISO_8859_1));
            generateExcel(list,title,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateExcel(List<Student> list, String[] title, HttpServletResponse response) throws IOException {
    //创建工作簿
        Workbook workbook;
        if (list.size()<=1000){
            workbook=new XSSFWorkbook();
        }else {
            workbook=new SXSSFWorkbook();
        }
        //创建sheet页
        Sheet sheet=workbook.createSheet();
        //创建第一行（表头）
        Row firstRow = sheet.createRow(0);
        firstRow.setHeight((short)(20*30));
        //创建列
        Cell top;
        for (int i = 0; i < title.length; i++) {
            top=firstRow.createCell(i);
            top.setCellValue(title[i]);
        }
        //设置表中数据
        setData(list,workbook,sheet,title);
        ByteArrayOutputStream tempStream=new ByteArrayOutputStream();
        workbook.write(tempStream);
        response.setHeader("Content-Length",""+tempStream.size());
        tempStream.close();
        //excel写入到输出流
        workbook.write(response.getOutputStream());

    }

    private void setData(List<Student> list, Workbook workbook, Sheet sheet, String[] title) {
        //填充数据
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < title.length; j++) {
                switch (title[j]){
                    case "姓名":
                    case "name":
                        Cell cell = row.createCell(j);
                        cell.setCellValue(student.getName());
                        break;
                    case "年龄":
                    case "age":
                        Cell age = row.createCell(j);
                        age.setCellValue(student.getAge());
                        break;
                    case "性别":
                    case "sex":
                        Cell sex = row.createCell(j);
                        sex.setCellValue(student.getSex());
                        break;
                    case "地址":
                    case "address":
                        Cell address = row.createCell(j);
                        address.setCellValue(student.getAddress());
                        break;
                        default:break;
                }
            }
        }
    }
}
