package com.stue.ebook.dao;

import com.stue.ebook.model.Book;
import com.stue.ebook.model.PageResult;
import com.stue.ebook.servlet.DefaultServlet;
import com.stue.ebook.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class BookDAO {
    private QueryRunner runner = DBUtil.getQueryRunner();
    private static final Logger logger = LoggerFactory.getLogger(DefaultServlet.class);
    public PageResult<Book> getBooks(Integer pageNum, Integer pageSize,Integer offset) throws SQLException {

        // 3. 查询总记录数
        String countSql = "SELECT COUNT(*) FROM book";
        Long totalRecords = runner.query(countSql, new ScalarHandler<>());

        // 4. 查询当前页数据
        String dataSql = "SELECT book_id as bookId, title, author,description,cover_image as coverImage  FROM book LIMIT ?, ?";
        List<Book> items = runner.query(dataSql, new BeanListHandler<>(Book.class), offset, pageSize);

        return new PageResult<>(pageNum, pageSize, totalRecords, totalRecords.intValue() / pageSize + 1, items);
    }

    public Book getBookDetail(Integer bookId) throws SQLException {
        String sql = "SELECT book_id as bookId, title, author,description,cover_image as coverImage  FROM book WHERE book_id = ?";
        Book book = runner.query(sql, new BeanHandler<>(Book.class), bookId);
        return book;
    }
}
