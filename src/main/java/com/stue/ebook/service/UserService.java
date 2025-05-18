package com.stue.ebook.service;


import com.stue.ebook.model.User;

public interface UserService {
    /**
     * 用户登录验证
     */
    User login(String username, String password);

    /**
     * 检查用户名可用性
     */
    boolean isUsernameAvailable(String username);

    /**
     * 查询用户
     */
    User findByUsername(String username);
}
