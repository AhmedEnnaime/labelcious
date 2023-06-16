package com.labelvie.lablecious.backend.services.impl;


import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.CategoryDto;
import com.labelvie.lablecious.backend.models.entity.Category;
import com.labelvie.lablecious.backend.repository.CategoryRepository;
import com.labelvie.lablecious.backend.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getCategories() {
        return CategoryDto.fromCategories(categoryRepository.findAll());
    }

    @Override
    public CategoryDto getCategoryById(long id) {
        return CategoryDto.fromCategory(this.findOrFail(id));
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        return CategoryDto.fromCategory(categoryRepository.save(categoryDto.toCategory()));
    }

    public CategoryDto updateCategory(long id, CategoryDto categoryDto) {
        categoryDto.setId(this.findOrFail(id).getId());
        return CategoryDto.fromCategory(categoryRepository.save(categoryDto.toCategory()));
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.delete(this.findOrFail(id));
    }

    @Override
    public Category findOrFail(long id) {
        return categoryRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("The category with id " + id + " does not exist"));
    }

}