package com.decolatech.rosa_blog_api.service;

import com.decolatech.rosa_blog_api.entity.User;
import com.decolatech.rosa_blog_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow();
  }

  public User updateUser(User user, Long id) {
    Optional<User> findUser = userRepository.findById(id);

    if (findUser.isEmpty()) {
      throw new RuntimeException("Usuário não encontrado.");
    }

    findUser.get().setUsername(user.getUsername());
    findUser.get().setPassword(user.getPassword());
    return userRepository.save(findUser.get());
  }

  public User deleteUser(Long id) {
    Optional<User> findUser = userRepository.findById(id);

    if (findUser.isEmpty()) {
      throw new RuntimeException("Usuário não encontrado.");
    }

    userRepository.deleteById(id);

    return findUser.get();
  }
}
