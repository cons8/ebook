package com.stue.ebook.model;

public class Result {
    private boolean success;
    private String message;
    private Object data;

    private  Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static Result success() {
        return new Result(true, null, null);
    }
}
