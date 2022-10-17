package com.db.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis动态数据源：
 * @Configuration
 * @MapperScan(basePackages = "com.db.mybatis.mapper.read", sqlSessionFactoryRef="rSqlSessionFactory")
 * 通过上述 mapper 绑定 数据源，从而实现动态的数据
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableTransactionManagement  // 开启事务
public class DbMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbMybatisApplication.class, args);
    }
}
