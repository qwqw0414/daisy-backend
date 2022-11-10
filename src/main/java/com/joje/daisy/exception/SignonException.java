package com.joje.daisy.exception;

public class SignonException extends RuntimeException {
    public SignonException() {}
    public SignonException(String message) {
        super(message);
    }
    public SignonException(String message, Throwable cause) {
        super(message, cause);
    }
}
