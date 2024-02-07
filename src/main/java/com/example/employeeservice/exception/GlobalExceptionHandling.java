package com.example.employeeservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(UserNotFound.class)
    public Map<String,String> handleUserNotFoundException(UserNotFound ex){
        Map<String,String> errormap = new HashMap<>();
        errormap.put("messsage",ex.getMessage());
        return errormap;
    }
}
