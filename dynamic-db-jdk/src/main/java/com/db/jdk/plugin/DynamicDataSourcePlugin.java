package com.db.jdk.plugin;

import com.db.jdk.datasourse.DynamicDataSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * 通过插件设值数据源：通过sql的操作方式判断数据源
 * 插件配置：如果不配置则不生效
 *  mybatis 插件: 插件设置数据源
 *   mybatis:
 *     configuration:
 *       interceptors:
 *         - com.db.jdk.plugin.DynamicDataSourcePlugin
 */
@Intercepts({
    @Signature(type = Executor.class, method = "update",
        args = {MappedStatement.class, Object.class}),
    @Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class DynamicDataSourcePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 拿到当前方法(update、query)所有参数
        Object[] objects = invocation.getArgs();

        // MappedStatement 封装CRUD所有的元素和SQL
        MappedStatement ms = (MappedStatement) objects[0];
        // 读方法
        if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {

            DynamicDataSource.NAME.set("R");
        } else {
            // 写方法
            DynamicDataSource.NAME.set("W");
        }
        // 修改当前线程要选择的数据源的key
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
