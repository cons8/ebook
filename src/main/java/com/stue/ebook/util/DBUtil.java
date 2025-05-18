package com.stue.ebook.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static DataSource dataSource;

    static {
        try {
            Properties props = new Properties();
            props.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));

            // 初始化 Druid 连接池
            DruidDataSource ds = new DruidDataSource();
            ds.setDriverClassName(props.getProperty("db.driver"));
            ds.setUrl(props.getProperty("db.url"));
            ds.setUsername(props.getProperty("db.username"));
            ds.setPassword(props.getProperty("db.password"));
            ds.setInitialSize(Integer.parseInt(props.getProperty("druid.initialSize")));
            ds.setMinIdle(Integer.parseInt(props.getProperty("druid.minIdle")));
            ds.setMaxActive(Integer.parseInt(props.getProperty("druid.maxActive")));
            ds.setMaxWait(Long.parseLong(props.getProperty("druid.maxWait")));

            dataSource = ds;

            // 可选：启用Druid监控
            // initDruidMonitor(ds);
        } catch (Exception e) {
            throw new RuntimeException("数据库连接池初始化失败", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 获取 QueryRunner 实例（自动管理连接）
    public static QueryRunner getQueryRunner() {
        return new QueryRunner(dataSource);
    }
}