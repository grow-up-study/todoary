package com.growup.todoary.exception;

public enum ExceptionMessage {

    NOT_EXISTENT_TODO("존재하지 않는 todo입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
