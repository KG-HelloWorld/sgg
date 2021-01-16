package com.example.demo.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.eduservice.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-12-19
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);
}
