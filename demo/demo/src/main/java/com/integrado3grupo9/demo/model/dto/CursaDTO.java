package com.integrado3grupo9.demo.model.dto;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class CursaDTO {

    private String nombreCarrera;
    private String nombreEstudiante;
    private LocalDate fechaInscripcion;
    private Long antiguedad;

    public CursaDTO(String nombreCarrera, String nombreEstudiante, LocalDate fechaInscripcion, Number anticudad) {
        this.nombreCarrera = nombreCarrera;
        this.nombreEstudiante = nombreEstudiante;
        this.fechaInscripcion = fechaInscripcion;
        this.antiguedad = anticudad.longValue();
    }

    @Override
    public String toString() {
        return "CursaDTO{" +
                "nombreCarrera='" + nombreCarrera + '\'' +
                ", nombreEstudiante='" + nombreEstudiante + '\'' +
                ", fechaInscripcion=" + fechaInscripcion +
                ", antiguedad=" + antiguedad +
                '}';
    }
}
