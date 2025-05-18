package com.stue.ebook.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
    public static String hashPassword(String plainText) {
        return BCrypt.hashpw(plainText, BCrypt.gensalt());
    }

    public static boolean verifyPassword(String plainText, String hash) {
        return BCrypt.checkpw(plainText, hash);
    }
}