package com.integrado3grupo9.demo.model.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Cursa {
    @EmbeddedId
    private CursaId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId ("dniEstudiante")
    @JoinColumn(name = "dni_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId ("idCarrera")
    @JoinColumn(name = "id_carrera", nullable = false)
    private Carrera carrera;

    @Column
    private int antiguedad;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column (name = "fecha_fin")
    private Date fechaFin;

    public Cursa() { super(); }

    public Cursa(CursaId id, Estudiante estudiante, Carrera carrera, int antiguedad, Date fechaInicio) {
        super();
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad = antiguedad;
        this.fechaInicio = fechaInicio;
    }

    public CursaId getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public int getAntiguedad() {
        return antiguedad;
    }



    @Override
    public String toString() {
        return "Cursa{" +
                "id=" + id +
                ", estudiante=" + estudiante +
                ", carrera=" + carrera +
                ", antiguedad=" + antiguedad +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
