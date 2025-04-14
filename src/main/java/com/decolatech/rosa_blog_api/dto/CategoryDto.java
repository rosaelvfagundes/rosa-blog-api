package com.decolatech.rosa_blog_api.dto;

import com.decolatech.rosa_blog_api.entity.Category;
import jakarta.validation.constraints.NotBlank;

public record CategoryDto(
    @NotBlank(message = "\"name\" is required")
    String name
) {
  public static CategoryDto fromEntity(Category category) {
    return new CategoryDto(
        category.getName()
    );
  }

  public Category toEntity() {
    Category category = new Category();
    category.setName(name);
    return category;
  }
}
