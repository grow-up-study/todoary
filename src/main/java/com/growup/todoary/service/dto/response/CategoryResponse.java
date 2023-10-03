package com.growup.todoary.service.dto.response;

import com.growup.todoary.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CategoryResponse {

    private long id;

    private String name;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
