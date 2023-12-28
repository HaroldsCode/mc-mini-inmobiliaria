package dev.harolds.springbootmicroservice3apigateway.controller;

import dev.harolds.springbootmicroservice3apigateway.entity.User;
import dev.harolds.springbootmicroservice3apigateway.service.AuthenticationService;
import dev.harolds.springbootmicroservice3apigateway.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "api/authentication" )
public class AuthenticationController {
    private AuthenticationService authenticationService;
    private UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        if ( userService.findByUsername( user.getUsername() ).isPresent() )
            return new ResponseEntity<>( HttpStatus.CONFLICT );

        User userCreated = userService.saveUser( user );

        return new ResponseEntity<User>( authenticationService.signUpAndReturnJwt(userCreated), HttpStatus.CREATED );
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user) {
        return new ResponseEntity<>(authenticationService.signInAndReturnJwt(user), HttpStatus.OK);
    }
}

