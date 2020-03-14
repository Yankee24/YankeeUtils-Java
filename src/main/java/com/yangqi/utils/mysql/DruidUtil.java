package com.yangqi.utils.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.yangqi.utils.isnull.NullUtil;
import com.yangqi.utils.properties.PropertiesUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The type MySQL conn util.
 *
 * @author Yankee
 * @date 2020 /3/13 22:42
 */
public class DruidUtil {
    // 获取 DataSource 对象
    private static DataSource dataSource = null;
    private static DruidDataSource druidDataSource = null;
    // 解析配置文件
    private static Properties prop = PropertiesUtil.getProperties("druid.properties");

    // 加载资源文件
    static {
        try {
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过自定义配置获取连接池对象
     */
    private static void createConnection() {
        if (NullUtil.isNull(druidDataSource)) {
            // 实例化 druidDataSource 对象
            druidDataSource = new DruidDataSource();

            // Druid 连接配置
            // 设置 mysql 连接地址
            druidDataSource.setUrl(prop.getProperty("url"));
            // 设置驱动类
            druidDataSource.setDriverClassName(prop.getProperty("driverClassName"));
            // 设置连接用户名
            druidDataSource.setUsername(prop.getProperty("username"));
            // 设置连接密码
            druidDataSource.setPassword(prop.getProperty("password"));

            // 数据库连接池相关配置
            // 设置初始化大小
            druidDataSource.setInitialSize(Integer.parseInt(prop.getProperty("initialSize")));
            // 设置最小空闲数量
            druidDataSource.setMinIdle(Integer.parseInt(prop.getProperty("minIdle")));
            // 设置最大空闲数量
            druidDataSource.setMaxActive(Integer.parseInt(prop.getProperty("maxActive")));
            // 设置获取连接超时等待时间
            druidDataSource.setMaxWait(Long.parseLong(prop.getProperty("maxWait")));
            // 获取连接等待超时时间
            druidDataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(prop.getProperty("timeBetweenEvictionRunsMillis")));
            // 连接池泄露检测
            druidDataSource.setRemoveAbandoned(true);
            druidDataSource.setRemoveAbandonedTimeout(Integer.parseInt(prop.getProperty("removeAbandonedTimeout")));
        }
    }

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public static Connection getConnection() {
        try {
            // 通过连接池获取连接对象
            createConnection();
            return druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("获取数据库连接异常");
    }

    /**
     * Gets connection by factory.
     *
     * @return the connection by factory
     */
    public static Connection getConnectionByFactory() {
        try {
            // 通过 druid 的工厂类获取
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("获取数据库连接异常");
    }

    /**
     * Release connection.
     *
     * @param rs   the rs
     * @param prep the prep
     * @param conn the conn
     */
    public static void releaseConnection(ResultSet rs, PreparedStatement prep, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (prep != null) {
                prep.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
