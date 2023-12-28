package dev.harolds.springbootmicroservice1inmueble.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.harolds.springbootmicroservice1inmueble.model.Inmueble;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {

}
