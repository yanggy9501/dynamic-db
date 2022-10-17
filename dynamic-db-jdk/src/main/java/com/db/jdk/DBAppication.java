package com.db.jdk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * JDK动态数据源：
 * 方式1：在准备连接mysql操作mysql时编程式设置数据源标识，AbstractRoutingDataSource 会自动切换数据源
 * 方式2：通过注解 + AOP，通过注解标识使用的数据源，在AOP中通过注解获取标识从而设置数据源标识
 * 方式3：通过mybatis插件，更加sql的操作类型决定使用哪个数据源，根据sql类型设置数据源标识
 *
 * ps：这三种方式相互独立，但是本质都是使用了jdk通过具有路由的数据源 AbstractRoutingDataSource
 */
@SpringBootApplication
@MapperScan("com.db.jdk.mapper")
@EnableAspectJAutoProxy(exposeProxy=true) // 启动AOP
public class DBAppication {
    public static void main(String[] args) {
        SpringApplication.run(DBAppication.class, args);
    }
}
