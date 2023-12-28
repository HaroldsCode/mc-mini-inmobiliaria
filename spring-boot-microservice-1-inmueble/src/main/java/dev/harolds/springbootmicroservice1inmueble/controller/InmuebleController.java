package dev.harolds.springbootmicroservice1inmueble.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.harolds.springbootmicroservice1inmueble.model.Inmueble;
import dev.harolds.springbootmicroservice1inmueble.service.InmuebleService;

@RestController
@RequestMapping( "api/inmueble" )
public class InmuebleController {
  private InmuebleService inmuebleService;

  public InmuebleController(InmuebleService inmuebleService) {
    this.inmuebleService = inmuebleService;
  }

  @PostMapping
  public ResponseEntity<?> createInmueble( @RequestBody Inmueble inmueble ) {
    return new ResponseEntity<Inmueble>(inmuebleService.saveInmueble(inmueble), HttpStatus.CREATED);
  }
  
  @GetMapping
  public ResponseEntity<?> findAll() {
    return new ResponseEntity<List<Inmueble>>(inmuebleService.findAll(), HttpStatus.OK);
  }

  @DeleteMapping("{inmuebleId}")
  public ResponseEntity<?> deleteInmueble( @PathVariable Long inmuebleId ) {
    inmuebleService.deleteInmueble(inmuebleId);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
