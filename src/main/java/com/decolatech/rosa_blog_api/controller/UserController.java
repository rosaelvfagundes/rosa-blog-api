package com.decolatech.rosa_blog_api.controller;

import com.decolatech.rosa_blog_api.dto.UserCreationDto;
import com.decolatech.rosa_blog_api.dto.UserDto;
import com.decolatech.rosa_blog_api.entity.User;
import com.decolatech.rosa_blog_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<UserDto>> getUsers() {
    List<UserDto> allUsers = userService.getUsers()
        .stream()
        .map(UserDto::fromEntity)
        .toList();

    return ResponseEntity.ok(allUsers);
  }

  @PostMapping
  public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreationDto userCreationDto) {
    User newUser = userService.createUser(userCreationDto.toEntity());
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(UserDto.fromEntity(newUser));
  }
}
