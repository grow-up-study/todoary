package com.growup.todoary.service;

import com.growup.todoary.domain.Todo;
import com.growup.todoary.service.dto.response.TodoResponse;
import com.growup.todoary.exception.ExceptionMessage;
import com.growup.todoary.exception.TodoNotFoundException;
import com.growup.todoary.repository.TodoRepository;
import com.growup.todoary.service.dto.request.TodoCreateRequest;
import com.growup.todoary.service.dto.request.TodoUpdateRequest;
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
                .toList();
    }

    public TodoResponse findById(Long id) {
        Todo todo = todoRepository.findById(id).
                orElseThrow(() -> new TodoNotFoundException(ExceptionMessage.TODO_NOT_FOUND));

        return TodoResponse.builder()
                .id(todo.getId())
                .content(todo.getContent())
                .date(todo.getDate())
                .build();
    }

    @Transactional
    public Long create(TodoCreateRequest request) {
        Todo todo = Todo.builder()
                .content(request.getName())
                .date(request.getDate())
                .build();
        Todo saved = todoRepository.save(todo);
        return saved.getId();
    }

    @Transactional
    public void update(Long id, TodoUpdateRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 Todo가 없습니다."));
        todo.update(request.getName(), request.getDate());
    }

    @Transactional
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
