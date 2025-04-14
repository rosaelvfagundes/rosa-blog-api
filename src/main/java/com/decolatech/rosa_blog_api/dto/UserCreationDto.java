package com.decolatech.rosa_blog_api.dto;

import com.decolatech.rosa_blog_api.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Optional;

public record UserCreationDto(
    @Size(min = 8, message = "\"displayName\" length must be at least 8 characters long")
    @NotBlank(message = "displayName is required")
    String displayName,

    @Email(message = "\"email\" must be a valid email")
    @NotBlank(message = "email is required")
    String email,

    @Size(min = 8, message = "\"password\" length must be at least 6 characters long")
    @NotBlank(message = "password is required")
    String password,

    Optional<String> image
) {
  public static UserCreationDto fromEntity(User user) {
    return new UserCreationDto(
        user.getDisplayName(),
        user.getEmail(),
        user.getPassword(),
        Optional.ofNullable(user.getImage())
    );
  }

  public User toEntity() {
    User user = new User();
    user.setDisplayName(displayName);
    user.setEmail(email);
    user.setPassword(password);
    user.setImage(String.valueOf(image));
    return user;
  }
}
