package com.satwat.todolistapi.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TodoNotFoundException.class)
    public String handleTodoNotFoundException (Exception ex){
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandeler(Exception ex){
        return ex.getMessage();
    }
}
