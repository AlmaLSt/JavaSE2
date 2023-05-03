package org.bedu.javase2.Postwork1.reactive;

import org.bedu.javase2.Postwork1.model.Curso;
import org.bedu.javase2.Postwork1.model.Estudiante;
import org.bedu.javase2.Postwork1.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class CalcularPromedioCursoRxTest {
    private static final Curso CURSO = new Curso();

    static {
        Estudiante estudiante1 = new Estudiante();
        Estudiante estudiante2 = new Estudiante();
        Estudiante estudiante3 = new Estudiante();

        estudiante1.setNombreCompleto("Juan");
        estudiante2.setNombreCompleto("Jahid");
        estudiante3.setNombreCompleto("Ana");

        Materia materia = new Materia();
        materia.setNombre("Java");

        CURSO.setCiclo("2023");
        CURSO.setMateria(materia);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(estudiante1, 9);
        calificaciones.put(estudiante2, 5);
        calificaciones.put(estudiante3, 10);

        CURSO.setCalificaciones(calificaciones);
    }

    @Test
    @DisplayName("Calcula promedio")
    void calculaPromedio(){
        CalcularPromedioCursoRx average = new CalcularPromedioCursoRx();

        average.calcularPromedio(CURSO)
                .subscribe(v -> assertThat(v).isEqualTo(8));

    }
}