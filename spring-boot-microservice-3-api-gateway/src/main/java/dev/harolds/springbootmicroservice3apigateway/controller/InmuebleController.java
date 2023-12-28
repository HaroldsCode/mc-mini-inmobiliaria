package dev.harolds.springbootmicroservice3apigateway.controller;

import dev.harolds.springbootmicroservice3apigateway.request.InmuebleServiceRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gateway/inmueble")
public class InmuebleController {
    private InmuebleServiceRequest inmuebleServiceRequest;

    public InmuebleController(InmuebleServiceRequest inmuebleServiceRequest) {
        this.inmuebleServiceRequest = inmuebleServiceRequest;
    }

    @PostMapping
    public ResponseEntity<?> saveInmueble(@RequestBody Object inmueble) {
        return new ResponseEntity<>(inmuebleServiceRequest.saveInmueble(inmueble), HttpStatus.CREATED);
    }

    @DeleteMapping("{inmuebleId}")
    public ResponseEntity<?> deleteInmueble(@PathVariable("inmuebleId") Long inmuebleId) {
        inmuebleServiceRequest.deleteInmueble(inmuebleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<?> getAllInmuebles(){
        return ResponseEntity.ok(inmuebleServiceRequest.getAllInmuebles());
    }
}
