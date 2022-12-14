package com.joje.daisy.exception;

public class ExpiredAccessTokenException extends RuntimeException {
    public ExpiredAccessTokenException() {}
    public ExpiredAccessTokenException(String message) {
        super(message);
    }
    public ExpiredAccessTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
