package com.stue.ebook.servlet;

import com.stue.ebook.model.Book;
import com.stue.ebook.model.PageResult;
import com.stue.ebook.service.BookService;
import com.stue.ebook.service.UserService;
import com.stue.ebook.service.impl.BookServiceImpl;
import com.stue.ebook.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/index")
public class DefaultServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    BookService bookService = new BookServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(DefaultServlet.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("DefaultServlet doGet");
        try {
            PageResult<Book> books = bookService.getBooks(1, 10);
            logger.info("books: {}", books);
            request.setAttribute("books", books);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 转发到实际的JSP页面
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
