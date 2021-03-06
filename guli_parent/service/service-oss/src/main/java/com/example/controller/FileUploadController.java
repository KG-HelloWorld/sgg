package com.example.controller;

import com.example.demo.R;
import com.example.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@Api(description="阿里云文件管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/oss/file")
public class FileUploadController {
    @Autowired
    private FileService fileService;
        /**
         13
         * 文件上传
         14
         *
         * @param file
         */
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public R upload(
@ApiParam(name = "file", value = "文件", required = true)
        @RequestParam("file") MultipartFile file) {
        String uploadUrl = fileService.upload(file);
        //返回r对象
        return R.ok().message("文件上传成功").data("url", uploadUrl);
    }
}