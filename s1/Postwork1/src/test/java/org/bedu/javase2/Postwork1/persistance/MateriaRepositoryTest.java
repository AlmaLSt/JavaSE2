package org.bedu.javase2.Postwork1.persistance;

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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.javase2.Postwork1")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MateriaRepositoryTest {
    @Autowired
    private MateriaRepository repository;

    @BeforeAll
    void cleanDatabase(){
        repository.deleteAll();
    }

    @Test
    @DisplayName("Guardado")
    void canSave(){
        Materia e = new Materia();
        e.setNombre("Materia prueba");

        e =repository.save(e);

        assertNotNull(e.getId());
    }

    @Test
    @DisplayName("Find by name")
    void canFindByName() {

        final String nombre = "Prueba busqueda";

        Materia materia = new Materia();

        materia.setNombre(nombre);

        repository.save(materia);

        assertNotNull(materia.getId());

        Iterable<Materia> listaMaterias = repository.findAllByNombre(nombre);
        assertTrue(listaMaterias.iterator().hasNext());

        Materia materiaRecuperada = listaMaterias.iterator().next();
        assertEquals(materia, materiaRecuperada);
    }
}