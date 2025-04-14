package com.decolatech.rosa_blog_api.controller;

import com.decolatech.rosa_blog_api.dto.PostCreationDto;
import com.decolatech.rosa_blog_api.dto.PostDto;
import com.decolatech.rosa_blog_api.entity.BlogPost;
import com.decolatech.rosa_blog_api.service.BlogPostService;
import com.decolatech.rosa_blog_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class BlogPostController {
  private BlogPostService blogPostService;

  @Autowired
  public BlogPostController(BlogPostService blogPostService, UserService userService) {
    this.blogPostService = blogPostService;
  }

  @GetMapping
  public ResponseEntity<List<PostDto>> getBlogPosts() {
    List<PostDto> allPosts = blogPostService.getBlogPosts().stream()
        .map(PostDto::fromEntity)
        .toList();
    return ResponseEntity.ok(allPosts);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PostDto> getBlogPost(@PathVariable Long id) {
    PostDto findPost = PostDto.fromEntity(blogPostService.getPostById(id));
    return ResponseEntity.ok(findPost);
  }

  @PostMapping
  public ResponseEntity<PostDto> createBlogPost(@RequestBody PostCreationDto postDto) {
    BlogPost createdPost = blogPostService.createBlogPost(postDto.toEntity());
    return ResponseEntity.status(HttpStatus.CREATED).body(PostDto.fromEntity(createdPost));
  }
}
