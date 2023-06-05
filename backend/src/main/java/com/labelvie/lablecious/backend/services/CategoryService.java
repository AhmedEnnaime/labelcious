package com.labelvie.lablecious.backend.services;


import com.labelvie.lablecious.backend.models.entity.Category;

import java.util.List;

public interface  CategoryService {
    List<Category> getCategories();
    Category saveCategory(Category category);


}
