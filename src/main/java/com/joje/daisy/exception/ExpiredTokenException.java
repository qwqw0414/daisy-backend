package com.joje.daisy.exception;

public class ExpiredTokenException extends RuntimeException {
    public ExpiredTokenException() {}
    public ExpiredTokenException(String message) {
        super(message);
    }
    public ExpiredTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
