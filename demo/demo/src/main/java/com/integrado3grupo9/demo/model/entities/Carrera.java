package com.integrado3grupo9.demo.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrera {
    @Id
    @Column(name = "id_carrera")
    private Long idCarrera;

    @Column(name = "nombre_carrera")
    private String nombreCarrera;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    List<Cursa> estudiantesMatriculados;

    public Carrera() {
        super();
    }

    public Carrera(Long idCarrera, String nombreCarrera) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.estudiantesMatriculados = new ArrayList<Cursa>();
    }

    public List<Cursa> getEstudiantesMatriculados() {
        return estudiantesMatriculados;
    }

    public void addEstudiantesMatriculados(Cursa estudianteMatriculado) {
        this.estudiantesMatriculados.add(estudianteMatriculado);
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id_carrera=" + idCarrera +
                ", nombre_carrera='" + nombreCarrera + '\'' +
                ", estudiantes=" + estudiantesMatriculados +
                '}';
    }
}
