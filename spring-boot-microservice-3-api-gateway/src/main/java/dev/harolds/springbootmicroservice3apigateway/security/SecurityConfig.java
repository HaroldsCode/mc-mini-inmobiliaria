package dev.harolds.springbootmicroservice3apigateway.security;

import dev.harolds.springbootmicroservice3apigateway.entity.Role;
import dev.harolds.springbootmicroservice3apigateway.security.jwt.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private CustomUserDetailsService customUserDetailsService;
    private PasswordEncoder passwordEncoder;

    private JwtAuthorizationFilter jwtAuthorizationFilter;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService, PasswordEncoder passwordEncoder, JwtAuthorizationFilter jwtAuthorizationFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth =
            http.getSharedObject( AuthenticationManagerBuilder.class );

        auth
            .userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder);

        AuthenticationManager authenticationManager = auth.build();

        return http
            .csrf().disable()
            .cors()
            .and()
            .authorizeRequests()
                .antMatchers("/api/authentication/**")
                .permitAll()
            .and()
            .authorizeRequests()
                .antMatchers("/api/**")
                .authenticated()
            .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/gateway/inmueble")
                .permitAll()
            .and()
            .authorizeRequests()
                .antMatchers("/gateway/inmueble/**")
                .hasRole(Role.ADMIN.name())
                .anyRequest()
                .authenticated()
            .and()
            .authenticationManager( authenticationManager )
            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .build();
    }
}
