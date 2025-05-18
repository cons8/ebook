package com.stue.ebook.service.impl;

import com.stue.ebook.dao.UserDAO;
import com.stue.ebook.model.User;
import com.stue.ebook.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAO();
    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public boolean isUsernameAvailable(String username) {
        return false;
    }

    @Override
    public User findByUsername(String username) {
        try {
            return userDAO.findByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
