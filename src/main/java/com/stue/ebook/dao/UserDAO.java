package com.stue.ebook.dao;

import com.stue.ebook.model.User;
import com.stue.ebook.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDAO {
    private QueryRunner runner = DBUtil.getQueryRunner();

    // 根据用户名查询用户
    public User findByUsername(String username) throws SQLException {
        String sql = "SELECT user_id as UserID, username,password_hash as passwordHash,role,email FROM user WHERE username = ?";
        return runner.query(sql, new BeanHandler<>(User.class), username);
    }
}
