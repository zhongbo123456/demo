package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @BelongProjecet demo
 * @BelongPackage com.example.demo.controller
 * @Description: 图片下载到文件夹然后进行压缩
 * @Author: zhongbo
 * @Date: 2020/3/27 16:21
 */
@RestController
@RequestMapping("/picture")
public class PictureController {

    @GetMapping("/download")
    public void downloadPic(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String path1="http://118.31.57.168:9000/pic/sE7bcmxjHCS/b4e62d9ef829/2019/8/29/1567055411_s.jpg";
        String path2="http://118.31.57.168:9000/pic/ZOtDKJz6YLm/9547a6b833ab515b/2019/2/19/1550541260.jpg";
        List<String> imgUrls=new ArrayList<>();
        imgUrls.add(path1);
        imgUrls.add(path2);
        ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
        try {
            String downloadFilename = "download.zip";// 文件的名称
            downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");// 转换中文否则可能会产生乱码
            response.setContentType("application/octet-stream");// 指明response的返回对象是文件流
            response.setHeader("Content-Disposition","attachment;filename="+downloadFilename);// 设置在下载框默认显示的文件名

            String[] files = new String[imgUrls.size()];
            imgUrls.toArray(files);
            Stream.of(files).forEach(s -> System.out.println(s));
            for (int i = 0; i < files.length; i++) {
                String url = files[i];
                zos.putNextEntry(new ZipEntry("pic" + File.separator+i+ ".jpg"));
                InputStream fis = getInputStreamByGet(url);
                byte[] buffer = new byte[1024];
                int r = 0;
                while ((r = fis.read(buffer)) != -1) {
                    zos.write(buffer, 0, r);
                }
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            zos.flush();
            zos.close();
        }

    }
    public static InputStream getInputStreamByGet(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();
                return inputStream;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }





}
