package com.integrado3grupo9.demo.model.dto;

import java.util.Date;

public class ReporteDTO {

    private String carreraNombre;
    private Date fecha;
    private Long cantidadInscriptos;
    private Long cantidadEgresados;

    public ReporteDTO(String carreraNombre, Date fecha, Number cantidadInscriptos, Number cantidadEgresados) {
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
