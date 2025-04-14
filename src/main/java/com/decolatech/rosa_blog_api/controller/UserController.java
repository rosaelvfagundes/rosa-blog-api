package com.decolatech.rosa_blog_api.controller;

import com.decolatech.rosa_blog_api.dto.UserCreationDto;
import com.decolatech.rosa_blog_api.dto.UserDto;
import com.decolatech.rosa_blog_api.entity.User;
import com.decolatech.rosa_blog_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreationDto userCreationDto) {
    User newUser = userService.createUser(userCreationDto.toEntity());
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(UserDto.fromEntity(newUser));
  }
}
