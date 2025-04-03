package com.example.scheduler_jpa.exceptionhandler;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
    super(message);
}
}
