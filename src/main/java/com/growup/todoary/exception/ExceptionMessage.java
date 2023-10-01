package com.growup.todoary.exception;

public enum ExceptionMessage {

    TODO_NOT_FOUND("존재하지 않는 todo입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
