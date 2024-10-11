package com.integrado3grupo9.demo.model.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class CursaId implements Serializable {

    @Column(name = "dni_estudiante")
    private Long dniEstudiante;
    @Column(name = "id_carrera")
    private Long idCarrera;

    public CursaId() {
        super();
    }
    public CursaId(Long dniEstudiante, Long idCarrera) {
        this.dniEstudiante = dniEstudiante;
        this.idCarrera = idCarrera;
    }

    public Long getDniEstudiante() {
        return dniEstudiante;
    }

    public void setDniEstudiante(Long dniEstudiante) {
        this.dniEstudiante = dniEstudiante;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }
}
