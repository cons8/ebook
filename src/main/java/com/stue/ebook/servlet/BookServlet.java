package com.stue.ebook.servlet;


import com.stue.ebook.model.Book;
import com.stue.ebook.service.BookService;
import com.stue.ebook.service.impl.BookServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(DefaultServlet.class);
    BookService bookService = new BookServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String idParam = request.getParameter("id");
        try {
           Book book = bookService.getBookDetail(Integer.parseInt(idParam));
            logger.info("查询书籍:{},{}", idParam, book);
            request.setAttribute("book", book);
            request.getRequestDispatcher("/jsp/book/book.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}