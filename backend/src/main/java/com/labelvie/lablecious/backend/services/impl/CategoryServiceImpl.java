package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.exceptions.handler.ResourceNotFoundException;
import com.labelvie.lablecious.backend.models.dto.CategoryDto;
import com.labelvie.lablecious.backend.models.entity.Category;
import com.labelvie.lablecious.backend.repository.CategoryRepository;
import com.labelvie.lablecious.backend.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return CategoryDto.fromCategories(categories);
    }

    @Override
    public CategoryDto getCategoryById(long id) {
        return CategoryDto.fromCategory(this.findOrFail(id));
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = new Category();
        updateCategoryFromDto(categoryDto, category);
        Category savedCategory = categoryRepository.save(category);
        return CategoryDto.fromCategory(savedCategory);
    }

    public CategoryDto updateCategory(long id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            updateCategoryFromDto(categoryDto, category);
            Category updatedCategory = categoryRepository.save(category);
            return CategoryDto.fromCategory(updatedCategory);
        }
        return null;
    }

    @Override
    public boolean deleteCategory(long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            categoryRepository.delete(optionalCategory.get());
            return true;
        }
        return false;
    }

    private void updateCategoryFromDto(CategoryDto categoryDto, Category category) {
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setPrice(categoryDto.getPrice());
    }

    @Override
    public Category findOrFail(long id) {
        return categoryRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("The category with id " + id + " does not exist"));
    }
}















