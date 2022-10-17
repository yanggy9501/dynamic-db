package com.db.jdk.service.impl;

import com.db.jdk.annotation.WR;
import com.db.jdk.entity.Course;
import com.db.jdk.mapper.CourseMapper;
import com.db.jdk.service.CourseService;
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

//    @Override
//    public List<Course> list() {
//        DynamicDataSource.NAME.set("R");
//        List<Course> list = courseMapper.list();
//        DynamicDataSource.NAME.remove();
//        return list;
//    }
//
//    @Override
//    public void insert() {
//        DynamicDataSource.NAME.set("W");
//        Course course = new Course();
//        course.setCid(4545498L);
//        course.setCname("dhfhdf");
//        course.setUserId(454544446L);
//        course.setCstatus("ok");
//        courseMapper.insert(course);
//        DynamicDataSource.NAME.remove();
//    }

    // 通过注解 + AOP 方式设置数据源
    @WR("R")
    @Override
    public List<Course> list() {
        List<Course> list = courseMapper.list();
        return list;
    }

    // 通过注解 + AOP 方式设置数据源
    @WR("W")
    @Override
    public void insert() {
        Course course = new Course();
        course.setCid(4545498L);
        course.setCname("dhfhdf");
        course.setUserId(454544446L);
        course.setCstatus("ok");
        courseMapper.insert(course);
    }
}




