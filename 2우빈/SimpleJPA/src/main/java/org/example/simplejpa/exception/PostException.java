package org.example.simplejpa.exception;

public class PostException extends IllegalArgumentException {
    public PostException(ErrorCode errorcode) {
        super(errorcode.message());
    }
}
