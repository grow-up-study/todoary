package com.growup.todoary.dto.response;

import com.growup.todoary.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
public class TodoResponse {

    private Long id;

    private String content;

    private LocalDate date;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.content = todo.getContent();
        this.date = todo.getDate();
    }
}
