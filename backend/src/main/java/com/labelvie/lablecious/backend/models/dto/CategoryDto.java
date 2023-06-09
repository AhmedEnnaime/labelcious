package com.labelvie.lablecious.backend.models.dto;


import com.labelvie.lablecious.backend.models.entity.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private long id;

    @NotBlank(message = "Name is required")
    @Min(value = 3, message = "Name must be at least 3 characters")
    private String name;

    @Min(value = 10, message = "Description must be at least 10 characters")
    private String description;

    @Min(value = 0, message = "Price must be greater than 0")
    private double price;

    public static CategoryDto fromCategory(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .price(category.getPrice())
                .build();
    }

    public static List<CategoryDto> fromCategories(List<Category> categories) {
        return categories.stream()
                .map(CategoryDto::fromCategory)
                .collect(Collectors.toList());
    }

    public Category toCategory() {
        return Category.builder()
                .id(this.getId())
                .name(this.getName())
                .description(this.getDescription())
                .price(this.getPrice())
                .build();
    }
}