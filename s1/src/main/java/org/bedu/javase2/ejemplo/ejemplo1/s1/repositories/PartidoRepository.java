package org.bedu.javase2.ejemplo.ejemplo1.s1.repositories;


import org.bedu.javase2.ejemplo.ejemplo1.s1.models.Partido;
import org.springframework.data.repository.CrudRepository;

public interface PartidoRepository extends CrudRepository <Partido, Long> {
}
