package com.stue.ebook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String username;
    private String passwordHash; // BCrypt加密存储
    private String email;
    private String role; // "admin" 或 "user"
    private Date createTime;
    private Date lastLogin;
}
