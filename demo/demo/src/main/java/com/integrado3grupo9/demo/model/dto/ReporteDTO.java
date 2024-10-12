package com.integrado3grupo9.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ReporteDTO implements Serializable {

    private String carreraNombre;
    //private Date fecha;
    private LocalDate fecha;
    private Long cantidadInscriptos;
    private Long cantidadEgresados;

    public ReporteDTO(String carreraNombre, LocalDate fecha, Number cantidadInscriptos, Number cantidadEgresados) {
        this.carreraNombre = carreraNombre;
        this.fecha = fecha;
        this.cantidadInscriptos = cantidadInscriptos.longValue();
        this.cantidadEgresados = cantidadEgresados.longValue();
    }

    @Override
    public String toString() {
        return "ReporteDTO{" +
                "carreraNombre='" + carreraNombre + '\'' +
                ", fecha=" + fecha +
                ", cantidadInscriptos=" + cantidadInscriptos +
                ", cantidadEgresados=" + cantidadEgresados +
                '}';
    }
}
