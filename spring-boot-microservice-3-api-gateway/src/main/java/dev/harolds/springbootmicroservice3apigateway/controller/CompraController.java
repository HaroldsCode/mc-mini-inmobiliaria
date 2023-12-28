package dev.harolds.springbootmicroservice3apigateway.controller;

import dev.harolds.springbootmicroservice3apigateway.request.ComprasServiceRequest;
import dev.harolds.springbootmicroservice3apigateway.security.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "gateway/compra" )
public class CompraController {
    private ComprasServiceRequest comprasServiceRequest;

    public CompraController(ComprasServiceRequest comprasServiceRequest) {
        this.comprasServiceRequest = comprasServiceRequest;
    }

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Object compra) {
        return new ResponseEntity<>( comprasServiceRequest.saveCompra(compra), HttpStatus.CREATED );
    }

    @GetMapping
    public ResponseEntity<?> getAllComprasByUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        System.out.println(userPrincipal.getId());
        return ResponseEntity.ok(comprasServiceRequest.findAllByUserId(userPrincipal.getId()));
    }
}
