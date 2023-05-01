package org.bedu.javase2.Postwork1.persistance;

import org.bedu.javase2.Postwork1.model.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
    Iterable<Estudiante> findAllByNombreCompleto(String nombreCompleto);

}