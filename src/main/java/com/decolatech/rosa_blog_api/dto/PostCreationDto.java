package com.decolatech.rosa_blog_api.dto;

import com.decolatech.rosa_blog_api.entity.BlogPost;
import com.decolatech.rosa_blog_api.entity.Category;

import java.time.LocalDateTime;
import java.util.List;

public record PostCreationDto(
    String title,
    String content,
    String description,
    List<Category> categories
) {
  public BlogPost toEntity() {
    BlogPost post = new BlogPost();

    post.setTitle(title);
    post.setContent(content);
    post.setDescription(description);
    post.setCategories(categories);
    post.setPublished(LocalDateTime.now());
    post.setUpdated(LocalDateTime.now());

    return post;
  }
}
