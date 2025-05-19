package com.stue.ebook.service;

import com.stue.ebook.model.Book;
import com.stue.ebook.model.BookShelf;
import com.stue.ebook.model.PageResult;

import java.sql.SQLException;

public interface BookService {
    /**
     * 添加新书籍
     */
    boolean addBook(Book book);
    /**
     * 批量删除书籍
     */
    boolean deleteBooks(Integer[] bookIds);

    /**
     * 修改书籍信息
     */
    boolean updateBook(Book book);

    /**
     * 获取书籍详细
     */
    Book getBookDetail(Integer bookId) throws SQLException;

    /**
     * 分页查询全部书籍
     *
     */
    PageResult<Book> getBooks(Integer pageNum, Integer pageSize) throws SQLException;
}
