package dev.harolds.springbootmicroservice2compra.service;

import dev.harolds.springbootmicroservice2compra.entity.Compra;

import java.util.List;

public interface CompraService {

    Compra saveCompra(Compra compra);

    List<Compra> findAllByUserId(Long userId);
}
