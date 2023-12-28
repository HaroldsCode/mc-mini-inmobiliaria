package dev.harolds.springbootmicroservice3apigateway.service;

import dev.harolds.springbootmicroservice3apigateway.entity.User;
import dev.harolds.springbootmicroservice3apigateway.security.UserPrincipal;
import dev.harolds.springbootmicroservice3apigateway.security.jwt.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private AuthenticationManager authenticationManager;
    private JwtProvider jwtProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public User signInAndReturnJwt(User signInRequest ) {
        Authentication authentication = authenticationManager
            .authenticate( new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken( userPrincipal );

        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }

    @Override
    public User signUpAndReturnJwt(User signUpRequest) {
        String jwt = jwtProvider.generateToken( signUpRequest );
        signUpRequest.setToken(jwt);
        return signUpRequest;
    }
}
