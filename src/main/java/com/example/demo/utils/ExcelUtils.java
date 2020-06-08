package com.example.demo.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.example.demo.common.MyException;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.utils
 * @Description:
 * @Author: zhongbo
 * @Date: 2020/5/22 17:48
 */
public class ExcelUtils {

    public static List<Object> getList(MultipartFile file, Class<? extends BaseRowModel> clazz){
        boolean empty = file.isEmpty();
        if(empty){
            throw new MyException("请上传excel",400);
        }
        InputStream inputStream=null;
        try {
            inputStream=file.getInputStream();
            List<Object> objectList = EasyExcelFactory.read(new BufferedInputStream(inputStream), new Sheet(1, 1, clazz));
            return objectList;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      return null;
    }
}
