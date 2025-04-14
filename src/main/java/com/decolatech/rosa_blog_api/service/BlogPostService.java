package com.decolatech.rosa_blog_api.service;

import com.decolatech.rosa_blog_api.advice.PostNotFoundException;
import com.decolatech.rosa_blog_api.entity.BlogPost;
import com.decolatech.rosa_blog_api.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
  private BlogPostRepository blogPostRepository;
  private CategoryService categoryService;

  @Autowired
  public BlogPostService(
      BlogPostRepository blogPostRepository,
      CategoryService categoryService
  ) {
    this.blogPostRepository = blogPostRepository;
    this.categoryService = categoryService;
  }

  public BlogPost getPostById(Long id) {
    return blogPostRepository.findById(id).orElseThrow();
  }

  public List<BlogPost> getBlogPosts() {
    return blogPostRepository.findAll();
  }

  public BlogPost createBlogPost(BlogPost blogPost) {
    return blogPostRepository.save(blogPost);
  }
}
