package com.integrado3grupo9.demo.model.dto.converter;

import com.integrado3grupo9.demo.model.dto.CursaIdDTO;
import com.integrado3grupo9.demo.model.entities.CursaId;
import org.springframework.stereotype.Component;

@Component
public class ConverterCursaIdDTO extends ConverterDTO<CursaId, CursaIdDTO>{


    @Override
    public CursaIdDTO fromEntity(CursaId e) {
        if (e == null) {
            return null;
        }
        return new CursaIdDTO(e.getDniEstudiante(), e.getIdCarrera());
    }

    @Override
    public CursaId fromDTO(CursaIdDTO d) {
        if(d == null) {
            return null;
        }

        return new CursaId(d.getDniEstudiante(), d.getIdCarrerra());
    }
}
