package com.decolatech.rosa_blog_api.repository;

import com.decolatech.rosa_blog_api.entity.BlogPost;
import com.decolatech.rosa_blog_api.entity.Category;
import com.decolatech.rosa_blog_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
  public List<BlogPost> findByCategories(Category category);
  public List<BlogPost> findByAuthor(User author);
}
