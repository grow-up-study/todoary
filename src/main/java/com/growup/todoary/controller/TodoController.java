package com.growup.todoary.controller;

import com.growup.todoary.domain.Todo;
import com.growup.todoary.service.TodoService;
import com.growup.todoary.service.dto.TodoCreateRequest;
import com.growup.todoary.service.dto.TodoUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok((todoService.getTodos()));
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid TodoCreateRequest request) {
        Long id = todoService.create(request);
        return ResponseEntity.created(URI.create("/todos/" + id)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid TodoUpdateRequest request) {
        todoService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
