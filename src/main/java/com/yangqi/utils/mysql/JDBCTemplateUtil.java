package com.yangqi.utils.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Jdbc template util.
 *
 * @author Yankee
 * @date 2020 /3/13 23:48
 */
public class JDBCTemplateUtil {
    // 工具类，私有化无参构造
    private JDBCTemplateUtil() {
    }

    /**
     * Update template.
     *
     * @param sql       the sql
     * @param arguments the arguments
     */
    public static void update(String sql, Object... arguments) {
        // 获取数据库连接 conn
        Connection conn = DruidUtil.getConnectionByFactory();
        // 创建数据库语句载体
        PreparedStatement prep = null;
        try {
            // 预编译 sql
            prep = conn.prepareStatement(sql);
            // 给预编译好的 sql 语句中的占位符进行赋值
            if (arguments != null && arguments.length > 0) {
                for (int i = 0; i < arguments.length; i++) {
                    prep.setObject(i + 1, arguments[i]);
                }
            }
            // 执行 sql 语句
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放数据库连接
            DruidUtil.releaseConnection(null, prep, conn);
        }
    }

    /**
     * Query template.
     *
     * @param <T>       the type parameter
     * @param sql       the sql
     * @param handler   the handler
     * @param arguments the arguments
     * @return the resultList
     */
    public static <T> T query(String sql, IResultSetHandler<T> handler, Object... arguments) {
        // 获取数据库连接 conn
        Connection conn = DruidUtil.getConnection();
        // 创建数据库语句载体
        PreparedStatement prep = null;
        // 创建结果集存储对象
        ResultSet rs = null;
        try {
            // 预编译 sql
            prep = conn.prepareStatement(sql);
            if (arguments != null && arguments.length > 0) {
                for (int i = 0; i < arguments.length; i++) {
                    prep.setObject(i + 1, arguments[i]);
                }
            }
            rs = prep.executeQuery();
            // 调用处理结果集对数据库查询结果进行封装
            return handler.handler(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DruidUtil.releaseConnection(rs, prep, conn);
        }
        return null;
    }
}
