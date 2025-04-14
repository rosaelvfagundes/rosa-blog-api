package com.decolatech.rosa_blog_api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="blog_posts")
public class BlogPost {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String content;
  private String description;

  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;

  private LocalDateTime published;
  private LocalDateTime updated;

  @ManyToMany
  @JoinTable(
      name = "posts_categories",
      joinColumns = @JoinColumn(name = "post_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  private List<Category> categories;

  public BlogPost() {}

  public BlogPost(String title, String content, String description, LocalDateTime published, LocalDateTime updated) {
    this.title = title;
    this.content = content;
    this.description = description;
    this.published = published;
    this.updated = updated;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LocalDateTime getPublished() {
    return published;
  }

  public void setPublished(LocalDateTime published) {
    this.published = published;
  }

  public LocalDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(LocalDateTime updated) {
    this.updated = updated;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }
}
