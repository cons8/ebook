package com.stue.ebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookId;         // 书籍ID（对应book_id）
    private String title;           // 书名（对应title）
    private String author;          // 作者（对应author）
    private String description;     // 描述（对应description）
    private String coverImage;      // 封面图片路径（对应cover_image）
    private String filePath;        // 文件存储路径（对应file_path）
    private Long fileSize;          // 文件大小（对应file_size）
    private Integer categoryId;     // 分类ID（对应category_id）
    private Boolean isFree;         // 是否免费（对应is_free）
    private Date uploadTime;        // 上传时间（对应upload_time）
    private Integer viewCount;      // 浏览次数（对应view_count）
    private Integer downloadCount;  // 下载次数（对应download_count）
}
