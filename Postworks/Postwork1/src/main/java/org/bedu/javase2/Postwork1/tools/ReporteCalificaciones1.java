//package org.bedu.javase2.Postwork1.tools;
//
//import org.bedu.javase2.Postwork1.model.Curso;
//import org.bedu.javase2.Postwork1.model.Estudiante;
//import org.springframework.stereotype.Component;
//
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Component
//public class ReporteCalificaciones1 {
//    static class Reporte {
//        private final String nombreEstudiante;
//        private final Integer calificacion;
//
//        public Reporte(String nombreEstudiante, Integer calificacion) {
//            this.nombreEstudiante = nombreEstudiante;
//            this.calificacion = calificacion;
//        }
//
//        public String getNombreEstudiante() {
//            return nombreEstudiante;
//        }
//
//        public Integer getCalificacion() {
//            return calificacion;
//        }
//    }
//
//    public List<Reporte> alfabetico(Curso curso){
//        return generaLista(curso.getCalificaciones(), Comparator.comparing(Reporte::getNombreEstudiante));
//    }
//
//    public List<Reporte> calificacion(Curso curso){
//        return generaLista(curso.getCalificaciones(), Comparator.comparing(Reporte::getCalificacion).reversed());
//    }
//
//    private List<Reporte> generaLista(Map<Estudiante, Integer> calificaciones, Comparator<Map.Entry<Estudiante, Integer>> comparator){
//        return calificaciones.entrySet().stream()
//                .map(e -> new Reporte(e.getKey().getNombreCompleto(), e.getValue()))
//                .sorted(comparator)
//                .collect(Collectors.toList());
//    }
//
//}
