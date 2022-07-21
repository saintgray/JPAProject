package com.jh.jpa.jpaservice.domain.exception;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
public class InvalidParamsException extends Exception{

    public InvalidParamsException() {
    }

    public InvalidParamsException(String message) {
        super(message);
    }
}
