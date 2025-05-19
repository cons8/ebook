package com.stue.ebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    // 分页元数据
    private int pageNum;       // 当前页码
    private int pageSize;      // 每页显示数量
    private long totalRecords; // 总记录数
    private int totalPages;    // 总页数

    // 当前页的数据列表
    private List<T> items;     // 数据集合
}
