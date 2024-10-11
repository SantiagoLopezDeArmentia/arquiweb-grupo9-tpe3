package com.integrado3grupo9.demo.model.dto.converter;

import com.integrado3grupo9.demo.model.entities.Carrera;
import com.integrado3grupo9.demo.model.dto.CarreraInscriptosDTO;
import org.springframework.stereotype.Component;

@Component
public class ConverterCarreraInscriptosDTO extends ConverterDTO<Carrera, CarreraInscriptosDTO> {
    @Override
    public CarreraInscriptosDTO fromEntity(Carrera e) {
        if(e == null)
            return null;

        return null;
    }

    @Override
    public Carrera fromDTO(CarreraInscriptosDTO d) {
        return null;
    }
}
