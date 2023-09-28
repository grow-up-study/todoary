package com.growup.todoary.service;

import com.growup.todoary.domain.Todo;
import com.growup.todoary.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return todoRepository.getTodos();
    }
}
