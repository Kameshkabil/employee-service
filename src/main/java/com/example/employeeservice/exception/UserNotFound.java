package com.example.employeeservice.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String message){
        super(message);
    }
}
