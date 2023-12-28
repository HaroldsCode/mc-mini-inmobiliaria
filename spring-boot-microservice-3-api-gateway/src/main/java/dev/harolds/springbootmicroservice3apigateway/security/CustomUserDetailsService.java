package dev.harolds.springbootmicroservice3apigateway.security;

import dev.harolds.springbootmicroservice3apigateway.entity.User;
import dev.harolds.springbootmicroservice3apigateway.service.UserService;
import dev.harolds.springbootmicroservice3apigateway.utils.SecurityUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("El usuario "+username+" no fue encontrado"));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority( user.getRole().name() ));

        return UserPrincipal.builder()
            .user(user)
            .id(user.getId())
            .username(username)
            .password(user.getPassword())
            .authorities(authorities)
            .build();
    }
}
