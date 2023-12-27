package com.example.kcelltask1.exception;

public class InvalidParamsException extends RuntimeException{
    InvalidParamsException() {
        super();
    }

    public InvalidParamsException(String message) {
        super(message);
    }
}
