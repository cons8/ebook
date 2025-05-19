package com.stue.ebook.service.impl;

import com.stue.ebook.dao.BookDAO;
import com.stue.ebook.model.Book;
import com.stue.ebook.model.BookShelf;
import com.stue.ebook.model.PageResult;
import com.stue.ebook.service.BookService;
import com.stue.ebook.servlet.DefaultServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class BookServiceImpl implements BookService {
    private static final Logger logger = LoggerFactory.getLogger(DefaultServlet.class);
    private BookDAO bookDAO = new BookDAO();
    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public boolean deleteBooks(Integer[] bookIds) {
        return false;
    }

    @Override
    public boolean updateBook(Book book) {
        return false;
    }

    @Override
    public Book getBookDetail(Integer bookId) throws SQLException {
        return bookDAO.getBookDetail(bookId);
    }

    @Override
    public PageResult<Book> getBooks(Integer pageNum, Integer pageSize) throws SQLException {
        // 1. 参数校验（确保页码和页大小合法）
        if (pageNum == null || pageNum < 1) pageNum = 1;
        if (pageSize == null || pageSize < 1) pageSize = 10;

        // 2. 计算分页偏移量
        int offset = (pageNum - 1) * pageSize;

        PageResult<Book> books = bookDAO.getBooks(pageNum, pageSize,offset);
        return books;
    }
}
