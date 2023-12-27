package com.example.kcelltask1.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidParamsException.class)
    protected ResponseEntity<AppError> invalidParams(InvalidParamsException exception) {
        return ResponseEntity
                .badRequest()
                .body(new AppError(HttpStatus.BAD_REQUEST.value(), exception.getMessage()));
    }
}
