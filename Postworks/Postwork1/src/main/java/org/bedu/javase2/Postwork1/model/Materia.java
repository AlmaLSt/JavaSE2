package org.bedu.javase2.Postwork1.model;


import jakarta.persistence.*;

import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table (name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    @Size(max = 45)
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materia() {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia)) return false;
        Materia materia = (Materia) o;
        return id.equals(materia.id) &&
                nombre.equals(materia.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

}
