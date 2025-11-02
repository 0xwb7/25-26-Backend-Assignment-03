package org.example.simplejpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostException extends RuntimeException {
    public PostException(ErrorMessage errorMessage) {
        super(errorMessage.message());
    }
}
