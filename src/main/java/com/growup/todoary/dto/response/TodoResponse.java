package com.growup.todoary.dto.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class TodoResponse {

    private Long id;

    private String content;

    private LocalDate date;
}
