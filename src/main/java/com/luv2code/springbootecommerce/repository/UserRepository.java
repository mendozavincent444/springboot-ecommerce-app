package com.luv2code.springbootecommerce.repository;

import com.luv2code.springbootecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
