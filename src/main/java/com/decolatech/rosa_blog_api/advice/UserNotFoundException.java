package com.decolatech.rosa_blog_api.advice;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException() {
    super("User does not exist");
  }
}
