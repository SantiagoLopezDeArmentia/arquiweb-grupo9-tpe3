package com.integrado3grupo9.demo.model.dto.converter;

import com.integrado3grupo9.demo.model.dto.CursaDTO;
import com.integrado3grupo9.demo.model.entities.Carrera;
import com.integrado3grupo9.demo.model.entities.Cursa;
import com.integrado3grupo9.demo.model.entities.CursaId;
import org.springframework.stereotype.Component;

@Component
public class ConverterCursaDTO extends ConverterDTO <Cursa, CursaDTO> {

    @Override
    public CursaDTO fromEntity(Cursa entity) {
        if (entity != null) {
            return new CursaDTO(entity.getCarrera().getNombreCarrera(), entity.getEstudiante().getNombre(), entity.getFechaInicio(), entity.getAntiguedad());
        }
        return null;
    }

    @Override
    public Cursa fromDTO(CursaDTO dto) {
        return null;
    }
}
