package com.decolatech.rosa_blog_api.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column(name="display_name")
  private String displayName;

  @Column(unique = true, nullable = false)
  private String email;

  private String password;
  private String image;

  @OneToMany(mappedBy = "user")
  private List<BlogPost> blogPosts;

  public User() {}

  public User(
      String displayName,
      String email,
      String password,
      String image
  ) {
    this.displayName = displayName;
    this.email = email;
    this.password = password;
    this.image = image;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<BlogPost> getBlogPosts() {
    return blogPosts;
  }

  public void setBlogPosts(List<BlogPost> blogPosts) {
    this.blogPosts = blogPosts;
  }
}
