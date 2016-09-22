package com.ip1x.jump.h2.mentorship.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Response Not Found")
public class ResponseNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResponseNotFoundException(String message) {
        super(message);
    }
}
