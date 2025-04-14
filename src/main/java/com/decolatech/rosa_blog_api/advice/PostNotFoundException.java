package com.decolatech.rosa_blog_api.advice;

public class PostNotFoundException extends RuntimeException{
  public PostNotFoundException(String message) {
    super("Post não encotrado.");
  }
}
