package com.decolatech.rosa_blog_api.repository;

import com.decolatech.rosa_blog_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  public Optional<Category> findByName(String name);
}
