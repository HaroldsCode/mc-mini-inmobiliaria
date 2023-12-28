package dev.harolds.springbootmicroservice2compra.controller;

import dev.harolds.springbootmicroservice2compra.entity.Compra;
import dev.harolds.springbootmicroservice2compra.service.CompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/compra")
public class CompraController {

    private CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra) {
        return new ResponseEntity<Compra>( compraService.saveCompra(compra), HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> findAllByUserId(@PathVariable Long userId) {
        return new ResponseEntity<List<Compra>>( compraService.findAllByUserId(userId), HttpStatus.OK );
    }
}
