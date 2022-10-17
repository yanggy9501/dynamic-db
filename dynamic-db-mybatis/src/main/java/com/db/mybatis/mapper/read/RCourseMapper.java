package com.db.mybatis.mapper.read;

import com.db.mybatis.entity.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.db.jdk.entity.Course
 */
public interface RCourseMapper {

    @Select("SELECT * FROM course_1")
    List<Course> list();
}




