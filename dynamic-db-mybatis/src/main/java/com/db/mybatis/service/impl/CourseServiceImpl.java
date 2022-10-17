package com.db.mybatis.service.impl;

import com.db.mybatis.entity.Course;
import com.db.mybatis.mapper.read.RCourseMapper;
import com.db.mybatis.mapper.write.WCourseMapper;
import com.db.mybatis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private RCourseMapper rcourseMapper;

    @Autowired
    private WCourseMapper wcourseMapper;



    @Override
    public List<Course> list() {
        List<Course> list = rcourseMapper.list();
        return list;
    }
    @Override
    public void insert() {Course course = new Course();
        course.setCid(4545498L);
        course.setCname("dhfhdf");
        course.setUserId(454544446L);
        course.setCstatus("ok");
        wcourseMapper.insert(course);
    }
}




