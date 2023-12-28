package dev.harolds.springbootmicroservice3apigateway.utils;

import dev.harolds.springbootmicroservice3apigateway.security.jwt.JwtAuthorizationFilter;
import dev.harolds.springbootmicroservice3apigateway.security.jwt.JwtProvider;
import dev.harolds.springbootmicroservice3apigateway.security.jwt.JwtProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServerUtils {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig)
            throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter() {
        return new JwtAuthorizationFilter( jwtProvider() );
    }

    @Bean
    public JwtProvider jwtProvider() {
        return new JwtProviderImpl();
    }
}
