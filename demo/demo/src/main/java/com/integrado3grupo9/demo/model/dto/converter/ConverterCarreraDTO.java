package com.integrado3grupo9.demo.model.dto.converter;

import com.integrado3grupo9.demo.model.entities.Carrera;
import com.integrado3grupo9.demo.model.dto.CarreraDTO;

public class ConverterCarreraDTO extends ConverterDTO<Carrera, CarreraDTO> {
    public Carrera fromDTO(CarreraDTO d) {
        if(d == null)
            return null;

        return new Carrera(d.getIdCarrera(), d.getNombreCarrera());
    }

    public CarreraDTO fromEntity(Carrera e) {
        if(e == null)
            return null;

        return new CarreraDTO(e.getIdCarrera(), e.getNombreCarrera());
    }
}
