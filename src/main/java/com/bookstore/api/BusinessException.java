package com.bookstore.api;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
