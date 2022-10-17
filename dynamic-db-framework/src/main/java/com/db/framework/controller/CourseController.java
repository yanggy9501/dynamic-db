package com.db.framework.controller;

import com.db.framework.entity.Course;
import com.db.framework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yanggy
 */
@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "select")
    public List<Course> select(){
        return courseService.list();
    }

    @GetMapping(value = "insert")
    public String insert(){
        courseService.insert();
        return "ok";
    }
}
