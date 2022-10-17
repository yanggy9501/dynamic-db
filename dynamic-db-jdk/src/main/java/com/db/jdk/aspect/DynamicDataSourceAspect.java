package com.db.jdk.aspect;

import com.db.jdk.datasourse.DynamicDataSource;
import com.db.jdk.annotation.WR;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author yanggy
 */
@Component
@Aspect
public class DynamicDataSourceAspect implements Ordered {
    // 前置
    @Before("within(com.db.jdk.service.impl.CourseServiceImpl.*) && @annotation(wr)")
    public void before(JoinPoint point, WR wr){
        String name = wr.value();
        DynamicDataSource.NAME.set(name);

        System.out.println(name);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
