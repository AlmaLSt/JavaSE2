package org.bedu.javase2.ejemplo.ejemplo1.s1.repositories;

import org.bedu.javase2.ejemplo.ejemplo1.s1.models.Equipo;
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
@ComponentScan(basePackages = "org.bedu.javase2.ejemplo.ejemplo1.s1")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EquipoRepositoryTest {
    @Autowired
    private EquipoRepository repository;

    @BeforeAll
    void cleanDatabase() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("Guardado")
    void canSave() {
        Equipo e = new Equipo();
        e.setNombre("prueba");

        e = repository.save(e);

        assertNotNull(e.getId());
    }

    @Test
    @DisplayName("Busca por nombre")
    void canFindByName() {
        final String nombre = "Prueba búsqueda";

        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);

        repository.save(equipo);

        Iterable<Equipo> listaEquipos = repository.findAllByNombre(nombre);
        assertTrue(listaEquipos.iterator().hasNext());

        Equipo equipoRecuperado = listaEquipos.iterator().next();
        assertEquals(equipo, equipoRecuperado);
    }

}