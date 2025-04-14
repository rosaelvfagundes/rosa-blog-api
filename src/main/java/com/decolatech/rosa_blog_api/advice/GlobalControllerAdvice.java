package com.decolatech.rosa_blog_api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalControllerAdvice {
  @ExceptionHandler({
      UserNotFoundException.class,
      PostNotFoundException.class
  })
  public ResponseEntity<String> handleNotFoundException(Exception e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
  }
}
