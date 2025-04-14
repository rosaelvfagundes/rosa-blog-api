package com.decolatech.rosa_blog_api.dto;

import com.decolatech.rosa_blog_api.entity.BlogPost;
import com.decolatech.rosa_blog_api.entity.Category;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.List;

public record PostDto(
    String title,
    String content,
    String description,
    LocalDateTime published,
    LocalDateTime updated
) {
  public static PostDto fromEntity(BlogPost post) {
    return new PostDto(
        post.getTitle(),
        post.getContent(),
        post.getDescription(),
        post.getPublished(),
        post.getUpdated()
    );
  }
}
