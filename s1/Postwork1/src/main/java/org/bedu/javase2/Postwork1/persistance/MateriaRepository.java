package org.bedu.javase2.Postwork1.persistance;

import org.bedu.javase2.Postwork1.model.Materia;
import org.springframework.data.repository.CrudRepository;

public interface MateriaRepository extends CrudRepository<Materia, Long> {
    Iterable<Materia> findAllByNombre(String nombre);
}
