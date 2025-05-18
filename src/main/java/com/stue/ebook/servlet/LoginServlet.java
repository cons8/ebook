package com.stue.ebook.servlet;

import com.stue.ebook.model.User;
import com.stue.ebook.service.UserService;
import com.stue.ebook.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(DefaultServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 1. 获取表单参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.info("username: {}, password: {}", username, password);

        // 2. 验证用户信息
        boolean isValidUser = validateUser(username, password);

        if (isValidUser) {
            // 3. 创建用户对象并存储到Session
            User user = getUserFromDatabase(username);
            request.getSession().setAttribute("user", user);
            // 4. 重定向到首页
            logger.info("login success:"+request.getContextPath());
            response.sendRedirect(request.getContextPath()+"/index");
        } else {
            // 5. 登录失败处理
            request.setAttribute("loginError", "用户名或密码错误");
            request.getRequestDispatcher("/jsp/user/login.jsp").forward(request, response);
        }
    }

    // 用户验证逻辑
    // TODO 密码加密后验证
    private boolean validateUser(String username, String password) {
        User user = userService.findByUsername(username);
        logger.info("user: {}", user);
        if (user == null) {
            return false;
        }
        return user.getUsername().equals(username) && user.getPasswordHash().equals(password);
    }

    // 从数据库获取用户数据
    private User getUserFromDatabase(String username) {
        return userService.findByUsername(username);
    }
}