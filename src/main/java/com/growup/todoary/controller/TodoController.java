package com.growup.todoary.controller;

import com.growup.todoary.domain.Todo;
import com.growup.todoary.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.findById(id));
    }
}
