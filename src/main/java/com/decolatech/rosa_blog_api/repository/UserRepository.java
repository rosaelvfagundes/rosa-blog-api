package com.decolatech.rosa_blog_api.repository;

import com.decolatech.rosa_blog_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { }
