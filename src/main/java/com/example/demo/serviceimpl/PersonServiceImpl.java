package com.example.demo.serviceimpl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.example.demo.common.MyException;
import com.example.demo.entity.ExcelStudent;
import com.example.demo.entity.Student;
import com.example.demo.entity.Student1;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.PersonService;
import com.example.demo.utils.ExcelUtils;
import com.example.demo.utils.MyResultUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    public static Integer second=3000;

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

    @Override
    public void excelData(HttpServletResponse response) {
        List<Student> list = personMapper.selectAll1();
        if(CollectionUtils.isEmpty(list)){
            throw new MyException("无数据",400);
        }
        List<ExcelStudent> sList=new ArrayList<>(list.size());
        list.forEach(student -> {
            ExcelStudent s=new ExcelStudent();
            s.setName(student.getName());
            s.setAge(student.getAge());
            s.setSex(student.getSex());
            s.setAddress(student.getAddress());
            sList.add(s);
        });
        // 2.使用ExcelWriter
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcelFactory.getWriter(response.getOutputStream(), ExcelTypeEnum.XLSX, Boolean.TRUE);
        } catch (IOException e) {
            System.out.println(e);
        }
        // 3.设置响应头
        String fileName = System.currentTimeMillis() + ".xlsx";
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        // 4.导出excel
        com.alibaba.excel.metadata.Sheet sheet = new com.alibaba.excel.metadata.Sheet(1, 0);
        sheet.setAutoWidth(Boolean.TRUE);
        sheet.setSheetName("设备类型");
        sheet.setClazz(sList.get(0).getClass());
        excelWriter.write(sList, sheet);
        excelWriter.finish();


    }

    @Override
    public void importData(MultipartFile file) {
        List<Object> list = ExcelUtils.getList(file, ExcelStudent.class);
        if(CollectionUtils.isNotEmpty(list)){
            list.forEach(o -> {
                Student student = JSON.parseObject(JSON.toJSONString(o), Student.class);
                try {
                    System.out.println(second);
                    Thread.sleep(second);
                    personMapper.insert(student);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
    }

    @Override
    public void updateSecond(Integer integer) {
        second=integer;

    }

    @Override
    public Integer getCount(String name) {
        Integer integer=personMapper.getCount(name);
        return integer;
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
