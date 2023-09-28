package com.growup.todoary.repository;

import com.growup.todoary.domain.Todo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final EntityManager em;

    public List<Todo> getTodos() {
        return em.createQuery("SELECT t FROM Todo t", Todo.class)
                .getResultList();
    }
}
