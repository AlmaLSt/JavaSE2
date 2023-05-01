package org.bedu.javase2.Postwork1.multithreading;

import org.bedu.javase2.Postwork1.model.Curso;

public class CalculadorPromedioCurso implements Runnable{
    private Curso curso;
    private double promedio;

    public CalculadorPromedioCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void run() {
        int Alumnos = 0;
        for(Integer i : curso.getCalificaciones().values()){
            promedio += i;
            Alumnos ++;
        }
        promedio /= Alumnos;

        System.out.println("Promedio del curso: " + curso.getId() + " " + curso.getMateria().getNombre() + " = " + promedio);
    }
}
