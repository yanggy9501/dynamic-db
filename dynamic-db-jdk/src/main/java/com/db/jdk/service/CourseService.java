package com.db.jdk.service;

import com.db.jdk.entity.Course;

import java.util.List;

/**
 *
 */
public interface CourseService {

    List<Course> list();

    void insert();
}
