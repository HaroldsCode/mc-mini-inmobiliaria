package dev.harolds.springbootmicroservice3apigateway.service;

import dev.harolds.springbootmicroservice3apigateway.entity.Role;
import dev.harolds.springbootmicroservice3apigateway.entity.User;
import dev.harolds.springbootmicroservice3apigateway.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword( passwordEncoder.encode(user.getPassword()) );
        user.setRole( Role.USER );
        user.setFechaCreacion( LocalDateTime.now() );

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void changeRole(Role role, String username) {
        userRepository.updateUserRole(username, role);
    }

}
