package com.labelvie.lablecious.backend.services.impl;

import com.labelvie.lablecious.backend.models.entity.Category;
import com.labelvie.lablecious.backend.repository.CategoryRepository;
import com.labelvie.lablecious.backend.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }



}



















