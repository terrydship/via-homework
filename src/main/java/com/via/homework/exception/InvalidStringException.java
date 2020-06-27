package com.via.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RuntimeException with a 400 http status code thrown when input string is not alpha-numerical
 *
 * @author Terry Deng
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidStringException extends RuntimeException {
    public InvalidStringException(String message) {
        super(message);
    }
}
