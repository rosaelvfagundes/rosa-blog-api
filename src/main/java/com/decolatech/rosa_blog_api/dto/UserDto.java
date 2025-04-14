package com.decolatech.rosa_blog_api.dto;

import com.decolatech.rosa_blog_api.entity.User;

import java.util.Optional;

public record UserDto(
    String displayName,
    String email,
    Optional<String> image
) {
  public static UserDto fromEntity(User user) {
    return new UserDto(
        user.getDisplayName(),
        user.getEmail(),
        Optional.ofNullable(user.getImage())
    );
  }
}
