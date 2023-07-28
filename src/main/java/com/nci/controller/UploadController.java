package com.nci.controller;

import com.nci.pojo.Result;
import com.nci.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    // Local storage file
/*    @PostMapping("/upload")
    public Result upload(String username , Integer age , MultipartFile image) throws Exception {
        log.info("upload file: {}, {}, {}", username, age, image);
        //Get original file name - 1.jpg  123.0.0.jpg
        String originalFilename = image.getOriginalFilename();

        //Construct a unique file name (cannot be duplicated) -uuid de49685b-61c0-4b11-80fa-c71e95924018
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("New file name: {}", newFileName);

        //将文件存储在服务器的磁盘目录中 E:\images
        image.transferTo(new File("/Users/wanpincai/Downloads/images:"+newFileName));

        return Result.success();*/

        @PostMapping("/upload")
        public Result upload(MultipartFile image) throws IOException {
            log.info("upload file, file name:{}",image.getOriginalFilename());

            //invoke AliOss tool upload
            String url = aliOSSUtils.upload(image);
            log.info("Upload success, url:{}",url);

            return Result.success(url);
        }
    }

