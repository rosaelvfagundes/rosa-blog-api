package com.decolatech.rosa_blog_api.service;

import com.decolatech.rosa_blog_api.entity.BlogPost;
import com.decolatech.rosa_blog_api.entity.Category;
import com.decolatech.rosa_blog_api.entity.User;
import com.decolatech.rosa_blog_api.repository.BlogPostRepository;
import com.decolatech.rosa_blog_api.repository.CategoryRepository;
import com.decolatech.rosa_blog_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {
  private BlogPostRepository blogPostRepository;
  private UserRepository userRepository;
  private CategoryRepository categoryRepository;

  @Autowired
  public BlogPostService(
      UserRepository userRepository,
      CategoryRepository categoryRepository,
      BlogPostRepository blogPostRepository
  ) {
    this.userRepository = userRepository;
    this.categoryRepository = categoryRepository;
    this.blogPostRepository = blogPostRepository;
  }

  public BlogPost createBlogPost(BlogPost blogPost) {
    return blogPostRepository.save(blogPost);
  }

  public BlogPost getBlogPostById(Long id) {
    Optional<BlogPost> findBlogPost = blogPostRepository.findById(id);

    if (findBlogPost.isEmpty()) {
      throw new RuntimeException("Post não encontrado");
    }

    return findBlogPost.get();
  }

  public List<BlogPost> getAllBlogPosts() {
    return blogPostRepository.findAll();
  }

  public BlogPost deleteBlogPost(Long id) {
    Optional<BlogPost> findBlogPost = blogPostRepository.findById(id);

    if (findBlogPost.isEmpty()) {
      throw new RuntimeException("Post não encontrado");
    }

    blogPostRepository.deleteById(id);

    return findBlogPost.get();
  }

  public BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost) {
    Optional<BlogPost> findBlogPost = blogPostRepository.findById(id);

    if (findBlogPost.isEmpty()) {
      throw new RuntimeException("Post não encontrado.");
    }

    findBlogPost.get().setTitle(updatedBlogPost.getTitle());
    findBlogPost.get().setContent(updatedBlogPost.getContent());

    return blogPostRepository.save(findBlogPost.get());
  }

  public List<BlogPost> getBlogPostsByCategory(Long categoryId) {
    Optional<Category> category = categoryRepository.findById(categoryId);

    if (category.isEmpty()) {
      throw new RuntimeException("Categoria não encontrada");
    }

    return blogPostRepository.findByCategories(category.get());
  }

  public List<BlogPost> getBlogPostsByAuthor(Long userId) {
    Optional<User> author = userRepository.findById(userId);

    if (author.isEmpty()) {
      throw new RuntimeException("Autor não encontrado");
    }

    return blogPostRepository.findByAuthor(author.get());
  }
}
