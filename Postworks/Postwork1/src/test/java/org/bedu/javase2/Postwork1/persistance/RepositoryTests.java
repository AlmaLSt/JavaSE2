package org.bedu.javase2.Postwork1.persistance;

import org.bedu.javase2.Postwork1.model.Curso;
import org.bedu.javase2.Postwork1.model.Estudiante;
import org.bedu.javase2.Postwork1.model.Materia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.javase2.Postwork1")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepositoryTests {
    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @BeforeAll
    void cleanDatabase(){
        materiaRepository.deleteAll();
        estudianteRepository.deleteAll();
        cursoRepository.deleteAll();
    }

    @Test
    @DisplayName("Guardar")
    void canSave(){
        Materia materia= new Materia();
        materia.setNombre("Materia prueba");
        materia =materiaRepository.save(materia);

        assertNotNull(materia.getId());

        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto("Beto Bedu");
        estudiante = estudianteRepository.save(estudiante);

        assertNotNull(estudiante.getId());

        Curso curso = new Curso();
        curso.setMateria(materia);
        curso.setCiclo("2023");

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(estudiante, Curso.NO_CALIFICADO);
        curso.setCalificaciones(calificaciones);

        curso = cursoRepository.save(curso);

        assertNotNull(curso.getId());
    }

    @Test
    @DisplayName("Find by name")
    void canFindByName() {

        final String nombre = "Prueba busqueda";

        Materia materia = new Materia();

        materia.setNombre(nombre);

        materiaRepository.save(materia);

        assertNotNull(materia.getId());

        Iterable<Materia> listaMaterias = materiaRepository.findAllByNombre(nombre);
        assertTrue(listaMaterias.iterator().hasNext());

        Materia materiaRecuperada = listaMaterias.iterator().next();
        assertEquals(materia, materiaRecuperada);


        //estudiante
        final String nombreCompleto = "Cosme Fulanito";

        Estudiante estudiante = new Estudiante();

        estudiante.setNombreCompleto(nombreCompleto);
        estudianteRepository.save(estudiante);

        assertNotNull(estudiante.getId());

        Iterable<Estudiante> listaEstudiantes = estudianteRepository.findAllByNombreCompleto(nombreCompleto);
        assertTrue(listaEstudiantes.iterator().hasNext());

        Estudiante estudianteRecuperado = listaEstudiantes.iterator().next();
        assertEquals(estudiante, estudianteRecuperado);
    }
}