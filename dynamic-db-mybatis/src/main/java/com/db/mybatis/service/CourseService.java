package com.db.mybatis.service;

import com.db.mybatis.entity.Course;

import java.util.List;

/**
 *
 */
public interface CourseService {

    List<Course> list();

    void insert();
}
