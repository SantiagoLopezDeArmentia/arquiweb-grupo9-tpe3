package com.integrado3grupo9.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class CarreraInscriptosDTO implements Serializable {
    private String nombre;
    private Long cantInscriptos;
    private List<EstudianteDTO> estudiantes;

    public CarreraInscriptosDTO(String nombre, Number cantInscriptos) {
        this.nombre = nombre;
        this.cantInscriptos = cantInscriptos.longValue();
        this.estudiantes = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "CarreraInscriptosDTO{" +
                "nombre='" + nombre + '\'' +
                ", cantInscriptos=" + cantInscriptos +
                '}';
    }
}
