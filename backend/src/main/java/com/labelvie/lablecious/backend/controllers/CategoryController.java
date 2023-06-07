package com.labelvie.lablecious.backend.controllers;


import com.labelvie.lablecious.backend.models.dto.CategoryDto;
import com.labelvie.lablecious.backend.models.entity.Category;
import com.labelvie.lablecious.backend.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categories = categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable long id) {
        CategoryDto category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategory = categoryService.saveCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable long id, @Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto updatedCategory = categoryService.updateCategory(id, categoryDto);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id) {
        boolean deleted = categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

