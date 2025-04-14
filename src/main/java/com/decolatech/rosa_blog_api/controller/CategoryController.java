package com.decolatech.rosa_blog_api.controller;

import com.decolatech.rosa_blog_api.dto.CategoryDto;
import com.decolatech.rosa_blog_api.entity.Category;
import com.decolatech.rosa_blog_api.service.CategoryService;
import com.decolatech.rosa_blog_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
  private CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService, UserService userService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public ResponseEntity<List<Category>> getCategories() {
    List<Category> categories = categoryService.getCategories();
    return ResponseEntity.ok(categories);
  }

  @PostMapping
  public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryDto category) {
    Category newCategory = categoryService.createCategory(category.toEntity());
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(newCategory);
  }
}
