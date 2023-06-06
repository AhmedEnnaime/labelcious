package com.labelvie.lablecious.backend.services;


import com.labelvie.lablecious.backend.models.dto.CategoryDto;
import com.labelvie.lablecious.backend.models.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getCategories();

    CategoryDto getCategoryById(long id);

    CategoryDto saveCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(long id, CategoryDto categoryDto);

    boolean deleteCategory(long id);

    Category findOrFail(long id);
}

























