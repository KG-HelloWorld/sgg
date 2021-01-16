package com.example.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.example.service.FileService;
import com.example.units.ConstantPropertiesUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public class FileServiceImpl implements FileService {
    @Override
    public String upload(MultipartFile file) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ConstantPropertiesUtil.END_POINT;
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;
        String uploadUrl = null;
        try {
// 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 获取上传上传的输入流。
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            ossClient.putObject(bucketName, fileName, inputStream);

            //获取url地址
            uploadUrl = "http://" + bucketName + "." + endpoint + "/" + fileName;

// 关闭OSSClient。
            ossClient.shutdown();
        }catch (Exception e){

        }

        return null;
    }
}
