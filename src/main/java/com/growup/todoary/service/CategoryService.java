package com.growup.todoary.service;

import com.growup.todoary.domain.Category;
import com.growup.todoary.repository.CategoryRepository;
import com.growup.todoary.service.dto.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
    }
}
