package com.stue.ebook.util;

public class PasswordValidator {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

    public static boolean isValid(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}