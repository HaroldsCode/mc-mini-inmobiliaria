package dev.harolds.springbootmicroservice3apigateway.controller;

import dev.harolds.springbootmicroservice3apigateway.entity.Role;
import dev.harolds.springbootmicroservice3apigateway.security.UserPrincipal;
import dev.harolds.springbootmicroservice3apigateway.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "api/user" )
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/change/{role}")
    public ResponseEntity<?> changeRoll(
        @AuthenticationPrincipal UserPrincipal userPrincipal,
        @PathVariable Role role
    ) {
        userService.changeRole( role, userPrincipal.getUsername() );
        return ResponseEntity.ok(true);
    }
}
