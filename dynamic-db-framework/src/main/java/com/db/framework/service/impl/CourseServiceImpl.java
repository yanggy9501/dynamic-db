package com.db.framework.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.db.framework.entity.Course;
import com.db.framework.mapper.CourseMapper;
import com.db.framework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    @DS("datasource1")
    public List<Course> list() {
        List<Course> list = courseMapper.list();
        return list;
    }

    @Override
    @DS("datasource2")
    public void insert() {
        Course course = new Course();
        course.setCid(4545498L);
        course.setCname("dhfhdf");
        course.setUserId(454544446L);
        course.setCstatus("ok");
        courseMapper.insert(course);
    }
}




