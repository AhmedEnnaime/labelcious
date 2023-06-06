package com.labelvie.lablecious.backend.controllers;


import com.labelvie.lablecious.backend.models.entity.Category;
import com.labelvie.lablecious.backend.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private  final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> index(){
        return categoryService.getCategories();
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

}


