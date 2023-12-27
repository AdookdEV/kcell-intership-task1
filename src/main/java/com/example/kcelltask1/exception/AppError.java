package com.example.kcelltask1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppError {
    private Integer status;
    private String message;
}
