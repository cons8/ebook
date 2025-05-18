package com.stue.ebook.servlet;

import com.stue.ebook.service.UserService;
import com.stue.ebook.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/")
public class DefaultServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(DefaultServlet.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 转发到实际的JSP页面
        response.sendRedirect("index.jsp");
    }
}
