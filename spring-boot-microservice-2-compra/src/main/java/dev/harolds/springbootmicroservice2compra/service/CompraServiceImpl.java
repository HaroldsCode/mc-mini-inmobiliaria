package dev.harolds.springbootmicroservice2compra.service;

import dev.harolds.springbootmicroservice2compra.entity.Compra;
import dev.harolds.springbootmicroservice2compra.repository.CompraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {

    private CompraRepository compraRepository;

    public CompraServiceImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public Compra saveCompra ( Compra compra ) {
        compra.setFechaCompra(LocalDateTime.now());
        return compraRepository.save(compra);
    }

    @Override
    public List<Compra> findAllByUserId(Long userId) {
        return compraRepository.findAllByUserId(userId);
    }
}
