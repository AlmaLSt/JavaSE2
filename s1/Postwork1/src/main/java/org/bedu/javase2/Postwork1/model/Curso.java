package org.bedu.javase2.Postwork1.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.TypeAlias;

import javax.validation.constraints.Size;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ciclo")
    @Size(max= 4)
    private String ciclo;

    @ManyToOne
    @JoinColumn(name = "materias_fk", referencedColumnName = "id")
    private Materia materia;

    public Curso(Long id, String ciclo, Materia materia) {
        this.id = id;
        this.ciclo = ciclo;
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
