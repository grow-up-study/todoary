package com.growup.todoary.exception;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
}
