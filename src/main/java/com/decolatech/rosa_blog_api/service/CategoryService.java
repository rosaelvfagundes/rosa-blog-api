package com.decolatech.rosa_blog_api.service;

import com.decolatech.rosa_blog_api.entity.Category;
import com.decolatech.rosa_blog_api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  private CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category createCategory(Category category) {
    return categoryRepository.save(category);
  }
}
