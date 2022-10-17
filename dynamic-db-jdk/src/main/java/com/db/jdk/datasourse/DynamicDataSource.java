package com.db.jdk.datasourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源(AbstractRoutingDataSource: 带路由功能的数据源)
 * 通过动态设值数据源标识来决定使用哪个数据源
 *
 * @author yanggy
 */

@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {
    // 当前使用的数据源标识
    public static ThreadLocal<String> NAME = new ThreadLocal<>();

    // 写
    @Autowired
    DataSource dataSource1;

    // 读
    @Autowired
    DataSource dataSource2;

    // 返回当前数据源标识；该值与afterPropertiesSet中配置决定使用哪个数据源
    @Override
    protected Object determineCurrentLookupKey() {
        return NAME.get();
    }

    @Override
    public void afterPropertiesSet() {
        // 为targetDataSources初始化所有数据源
        Map<Object, Object> targetDataSources=new HashMap<>(2);
        targetDataSources.put("W",dataSource1);
        targetDataSources.put("R",dataSource2);

        super.setTargetDataSources(targetDataSources);

        // 为defaultTargetDataSource 设置默认的数据源
        super.setDefaultTargetDataSource(dataSource1);

        super.afterPropertiesSet();
    }
}
