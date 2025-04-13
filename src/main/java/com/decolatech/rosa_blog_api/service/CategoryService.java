package com.decolatech.rosa_blog_api.service;

import com.decolatech.rosa_blog_api.entity.Category;
import com.decolatech.rosa_blog_api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

  public Category getCategoryById(Long id) {
    Optional<Category> findCategory = categoryRepository.findById(id);

    if (findCategory.isEmpty()) {
      throw new RuntimeException("Categoria não encontrada.");
    }

    return findCategory.get();
  }

  public Category getCategoryByName(String name) {
    Optional<Category> findCategory = categoryRepository.findByName(name);

    if (findCategory.isEmpty()) {
      throw new RuntimeException("Categoria não encontrada.");
    }

    return findCategory.get();
  }

  public Category updateCategory(Long id, Category updatedCategory) {
    Optional<Category> findCategory = categoryRepository.findById(id);

    if (findCategory.isEmpty()) {
      throw new RuntimeException("Categoria não encontrada.");
    }

    findCategory.get().setName(updatedCategory.getName());

    return categoryRepository.save(findCategory.get());
  }

  public Category deleteCategory(Long id) {
    Optional<Category> findCategory = categoryRepository.findById(id);

    if (findCategory.isEmpty()) {
      throw new RuntimeException("Categoria não encontrada.");
    }

    categoryRepository.deleteById(id);

    return findCategory.get();
  }
}
