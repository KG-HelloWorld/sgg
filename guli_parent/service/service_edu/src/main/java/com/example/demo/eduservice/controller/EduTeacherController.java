package com.example.demo.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.R;
import com.example.demo.eduservice.entity.EduTeacher;
import com.example.demo.eduservice.entity.vo.TeacherQuery;
import com.example.demo.eduservice.service.EduTeacherService;
import com.example.demo.exceptionhandler.DiyException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-12-19
 */
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("items",list);
    }
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@PathVariable String id){
        boolean flag = eduTeacherService.removeById(id);
        if (flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

//    @ApiOperation(value = "分页讲师列表")
//    @GetMapping("{page}/{limit}")
//    public R pageList(
//@ApiParam(name = "page", value = "当前页码", required = true)
//        @PathVariable Long page,
//@ApiParam(name = "limit", value = "每页记录数", required = true)
//        @PathVariable Long limit){
//        Page<EduTeacher> pageParam = new Page<>(page, limit);
//
//        eduTeacherService.page(pageParam, null);
//
//        List<EduTeacher> records = pageParam.getRecords();
//
//        long total = pageParam.getTotal();
//
//        return  R.ok().data("total", total).data("rows", records);
//    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
@ApiParam(name = "page", value = "当前页码", required = true)
        @PathVariable Long page,
@ApiParam(name = "limit", value = "每页记录数", required = true)
        @PathVariable Long limit){
        Page<EduTeacher> pageParam = new Page<>(page, limit);

        try{
            int i = 10/0;
        }catch (Exception e){
            //执行自定义异常
            throw new DiyException(20001,"执行了自定义异常");
        }
        eduTeacherService.page(pageParam, null);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }



//@PostMapping("pageTeacherCondition/{current}{limit}")
//    public R pageTeacherCondition(@PathVariable long current,
//                                  @PathVariable long limit,
//                                  @RequestBody(required = false) TeacherQuery teacherQuery){
//
//    Page<EduTeacher> teacherPage = new Page<>(current,limit);
//
//    QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
//
//    String name = teacherQuery.getName();
//    Integer level = teacherQuery.getLevel();
//    String begin = teacherQuery.getBegin();
//    String end = teacherQuery.getEnd();
//
//    if (StringUtils.isEmpty(name)){
//        wrapper.like("name",name);
//    }
//
//    if (!StringUtils.isEmpty(Integer.toString(level)) ) {
//        wrapper.eq("level", level);
//    }
//    if (!StringUtils.isEmpty(begin)) {
//        wrapper.ge("gmt_create", begin);
//    }
//    if (!StringUtils.isEmpty(end)) {
//        wrapper.le("gmt_create", end);
//    }
//    eduTeacherService.page(teacherPage,wrapper);
//    List<EduTeacher> records = teacherPage.getRecords();
//
//    long total = teacherPage.getTotal();
//
//    return  R.ok().data("total", total).data("rows", records);
//
//}

    @ApiOperation(value = "分页讲师列表2")
    @GetMapping("pageTeacherCondition{page}/{limit}")
    public R pageQuery(
@ApiParam(name = "page", value = "当前页码", required = true)
        @PathVariable Long page,
@ApiParam(name = "limit", value = "每页记录数", required = true)
        @PathVariable Long limit,
@ApiParam(name = "teacherQuery", value = "查询对象", required = false)
        TeacherQuery teacherQuery){
        Page<EduTeacher> pageParam = new Page<>(page, limit);
        eduTeacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping
    public R save(
@ApiParam(name = "teacher", value = "讲师对象", required = true)
        @RequestBody EduTeacher teacher){
        eduTeacherService.save(teacher);
        return R.ok();
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("{id}")
    public R getById(
@ApiParam(name = "id", value = "讲师ID", required = true)
        @PathVariable String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return R.ok().data("item", teacher);
    }


    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("{id}")
    public R updateById(
@ApiParam(name = "id", value = "讲师ID", required = true)
        @PathVariable String id,
@ApiParam(name = "teacher", value = "讲师对象", required = true)
        @RequestBody EduTeacher teacher){
        teacher.setId(id);
        eduTeacherService.updateById(teacher);
        return R.ok();
    }

}

