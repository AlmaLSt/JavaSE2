package org.bedu.javase2.ejemplo.ejemplo1.s1.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "partidos")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipos1_fk", referencedColumnName = "id")
    private Equipo equipo1;

    @ManyToOne
    @JoinColumn(name = "equipos2_fk", referencedColumnName = "id")
    private Equipo equipo2;

    @Column(name = "marcador_equipo1")
    private Integer marcadorEquipo1;

    @Column(name = "marcador_equipo2")
    private Integer getMarcadorEquipo2;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public Integer getMarcadorEquipo1() {
        return marcadorEquipo1;
    }

    public void setMarcadorEquipo1(Integer marcadorEquipo1) {
        this.marcadorEquipo1 = marcadorEquipo1;
    }

    public Integer getGetMarcadorEquipo2() {
        return getMarcadorEquipo2;
    }

    public void setGetMarcadorEquipo2(Integer getMarcadorEquipo2) {
        this.getMarcadorEquipo2 = getMarcadorEquipo2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partido partido)) return false;
        return Objects.equals(getId(), partido.getId()) && Objects.equals(getEquipo1(), partido.getEquipo1()) && Objects.equals(getEquipo2(), partido.getEquipo2()) && Objects.equals(getMarcadorEquipo1(), partido.getMarcadorEquipo1()) && Objects.equals(getGetMarcadorEquipo2(), partido.getGetMarcadorEquipo2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEquipo1(), getEquipo2(), getMarcadorEquipo1(), getGetMarcadorEquipo2());
    }
}
