package dev.harolds.springbootmicroservice2compra.repository;

import dev.harolds.springbootmicroservice2compra.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findAllByUserId( Long userId );
}
