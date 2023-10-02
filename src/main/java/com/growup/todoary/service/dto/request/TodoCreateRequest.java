package com.growup.todoary.service.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoCreateRequest {

    @NotNull(message = "name은 null이면 안됩니다.")
    private final String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "date는 null이면 안됩니다.")
    private final LocalDate date;
}
