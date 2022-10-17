package com.db.framework.service;


import com.db.framework.entity.Course;

import java.util.List;

/**
 *
 */
public interface CourseService {

    List<Course> list();

    void insert();
}
