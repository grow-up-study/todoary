package com.growup.todoary.service;

import com.growup.todoary.domain.Todo;
import com.growup.todoary.dto.response.TodoResponse;
import com.growup.todoary.exception.TodoNotFoundException;
import com.growup.todoary.exception.ExceptionMessage;
import com.growup.todoary.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<TodoResponse> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(TodoResponse::new)
                .collect(Collectors.toList());
    }

    public TodoResponse findById(Long id) {
        Todo todo =  todoRepository.findById(id).
                orElseThrow(() -> new TodoNotFoundException(ExceptionMessage.TODO_NOT_FOUND));

        return TodoResponse.builder()
                .id(todo.getId())
                .content(todo.getContent())
                .date(todo.getDate())
                .build();
    }
}
