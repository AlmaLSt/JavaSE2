package org.bedu.javase2.ejemplo.ejemplo1.s1.repositories;

import org.bedu.javase2.ejemplo.ejemplo1.s1.models.Equipo;
import org.springframework.data.repository.CrudRepository;

public interface EquipoRepository extends CrudRepository<Equipo, Long> {
}
