package com.growup.todoary.service;

import com.growup.todoary.domain.Todo;
import com.growup.todoary.exception.TodoNotFoundException;
import com.growup.todoary.exception.ExceptionMessage;
import com.growup.todoary.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(Long id) {
        return todoRepository.findById(id).
                orElseThrow(() -> new TodoNotFoundException(ExceptionMessage.TODO_NOT_FOUND));
    }
}
