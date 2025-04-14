package com.decolatech.rosa_blog_api.service;

import com.decolatech.rosa_blog_api.advice.UserNotFoundException;
import com.decolatech.rosa_blog_api.entity.User;
import com.decolatech.rosa_blog_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(UserNotFoundException::new);
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }
}
