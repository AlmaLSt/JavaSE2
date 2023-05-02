package org.bedu.javase2.Postwork1.tools;

import org.bedu.javase2.Postwork1.model.Curso;
import org.bedu.javase2.Postwork1.model.Estudiante;
import org.bedu.javase2.Postwork1.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.map;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ReporteCalificaciones1Test {
    private static final Materia MATERIA = new Materia();
    private static final Estudiante ESTUDIANTE_1 = new Estudiante();
    private static final Estudiante ESTUDIANTE_2 = new Estudiante();
    private static final Estudiante ESTUDIANTE_3 = new Estudiante();
    private static final Curso CURSO = new Curso();

    private static ReporteCalificaciones1.Reporte reporte1;
    private static ReporteCalificaciones1.Reporte reporte2;
    private static ReporteCalificaciones1.Reporte reporte3;

    static {
        MATERIA.setNombre("Java");

        ESTUDIANTE_1.setNombreCompleto("Beto");
        ESTUDIANTE_2.setNombreCompleto("Paula");
        ESTUDIANTE_3.setNombreCompleto("Mike");

        CURSO.setCiclo("2023");
        CURSO.setMateria(MATERIA);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(ESTUDIANTE_1, 6);
        calificaciones.put(ESTUDIANTE_2, 10);
        calificaciones.put(ESTUDIANTE_3, 7);

        CURSO.setCalificaciones(calificaciones);

        reporte1 = new ReporteCalificaciones1.Reporte("Paula", 10);
        reporte2 = new ReporteCalificaciones1.Reporte("Beto", 6);
        reporte3 = new ReporteCalificaciones1.Reporte("Mike", 7);
    }

@Test
@DisplayName("Ordena alfabéticamente")
void alfabetico(){
    ReporteCalificaciones1 reporteCalificaciones = new ReporteCalificaciones1();

    assertThat(reporteCalificaciones.alfabetico(CURSO)).containsExactly(reporte2, reporte3, reporte1);
}


    @Test
    @DisplayName("Ordena por calificaciones")
    void calificaciones(){
        ReporteCalificaciones1 reporteCalificaciones = new ReporteCalificaciones1();

        assertThat(reporteCalificaciones.calificacion(CURSO)).containsExactly(reporte1, reporte3, reporte2);
    }
}