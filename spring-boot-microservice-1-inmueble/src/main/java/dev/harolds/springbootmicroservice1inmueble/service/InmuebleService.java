package dev.harolds.springbootmicroservice1inmueble.service;

import dev.harolds.springbootmicroservice1inmueble.model.Inmueble;
import java.util.List;

public interface InmuebleService {

  public Inmueble saveInmueble( Inmueble inmueble );

  public void deleteInmueble( Long inmuebId );

  public List<Inmueble> findAll();
  
}
