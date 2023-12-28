package dev.harolds.springbootmicroservice3apigateway.service;

import dev.harolds.springbootmicroservice3apigateway.entity.User;
import dev.harolds.springbootmicroservice3apigateway.security.jwt.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;

public interface AuthenticationService {
    User signInAndReturnJwt(User signInRequest);

    User signUpAndReturnJwt(User signInRequest);
}
