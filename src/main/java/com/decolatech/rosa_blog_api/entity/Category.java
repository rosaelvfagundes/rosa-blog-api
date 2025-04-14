package com.decolatech.rosa_blog_api.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @ManyToMany(mappedBy = "categories")
  private List<BlogPost> blogPosts;

  public Category() {}

  public Category(String name, Long id) {
    this.name = name;
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<BlogPost> getBlogPosts() {
    return blogPosts;
  }

  public void setBlogPosts(List<BlogPost> blogPosts) {
    this.blogPosts = blogPosts;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
