package com.stue.ebook.service;

import com.stue.ebook.model.Book;
import com.stue.ebook.model.PageResult;

import java.sql.SQLException;

public interface RecommendationService {
    /**
     * 获取推荐列表
     * @param pageNum
     * @param pageSize
     * @return
     * @throws SQLException
     */
    PageResult<Book> getRecommendations(Integer pageNum, Integer pageSize) throws SQLException;
}
