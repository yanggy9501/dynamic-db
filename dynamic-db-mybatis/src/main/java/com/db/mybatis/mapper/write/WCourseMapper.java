package com.db.mybatis.mapper.write;

import com.db.mybatis.entity.Course;
import org.apache.ibatis.annotations.Insert;

/**
 * @Entity com.db.jdk.entity.Course
 */
public interface WCourseMapper {

    @Insert("insert into course_1 VALUES (#{cid}, #{cname}, #{userId}, #{cstatus})")
    void insert(Course course);
}




