package dev.harolds.springbootmicroservice1inmueble.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.harolds.springbootmicroservice1inmueble.model.Inmueble;
import dev.harolds.springbootmicroservice1inmueble.repository.InmuebleRepository;

@Service
public class InmuebleServiceImpl implements InmuebleService {

	private final InmuebleRepository inmuebleRepository;

    InmuebleServiceImpl(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    @Override
    public Inmueble saveInmueble( Inmueble inmueble ) {
    	inmueble.setFechaCreacion(LocalDateTime.now());
        return inmuebleRepository.save(inmueble);
    }

    @Override
    public void deleteInmueble( Long inmuebId ) {
        inmuebleRepository.deleteById(inmuebId);
    }

    @Override
    public List<Inmueble> findAll() {
        return inmuebleRepository.findAll();
    }

}
