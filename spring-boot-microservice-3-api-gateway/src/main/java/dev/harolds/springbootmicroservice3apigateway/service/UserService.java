package dev.harolds.springbootmicroservice3apigateway.service;

import dev.harolds.springbootmicroservice3apigateway.entity.Role;
import dev.harolds.springbootmicroservice3apigateway.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role role, String username);
}
