package com.growup.todoary.service;

import com.growup.todoary.domain.Todo;
import com.growup.todoary.repository.TodoRepository;
import com.growup.todoary.service.dto.TodoCreateRequest;
import com.growup.todoary.service.dto.TodoUpdateRequest;
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
