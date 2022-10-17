package com.db.jdk.mapper;

import com.db.jdk.entity.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.db.jdk.entity.Course
 */
public interface CourseMapper {

    @Select("SELECT * FROM course_1")
    List<Course> list();

    @Insert("insert into course_1 VALUES (#{cid}, #{cname}, #{userId}, #{cstatus})")
    void insert(Course course);
}




