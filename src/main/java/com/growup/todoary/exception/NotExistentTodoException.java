package com.growup.todoary.exception;

public class NotExistentTodoException extends RuntimeException{

    public NotExistentTodoException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
    }
}
