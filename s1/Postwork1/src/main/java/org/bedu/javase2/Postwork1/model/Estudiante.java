package org.bedu.javase2.Postwork1.model;

import jakarta.persistence.*;

import javax.validation.constraints.Size;

@Entity
@Table (name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre_completo")
    @Size(max = 45)
    private String nombre_completo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public Estudiante(Long id, String nombre_completo) {
        this.id = id;
        this.nombre_completo = nombre_completo;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
