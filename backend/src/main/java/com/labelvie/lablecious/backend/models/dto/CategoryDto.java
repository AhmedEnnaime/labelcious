package com.labelvie.lablecious.backend.models.dto;


import com.labelvie.lablecious.backend.models.entity.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be a positive number")
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
}
