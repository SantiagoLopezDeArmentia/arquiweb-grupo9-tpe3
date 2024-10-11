package com.integrado3grupo9.demo.model.dto.converter;

import com.integrado3grupo9.demo.model.entities.Estudiante;
import com.integrado3grupo9.demo.model.dto.EstudianteDTO;
import org.springframework.stereotype.Component;

@Component
public class ConverterEstudianteDTO extends ConverterDTO<Estudiante, EstudianteDTO> {
    public Estudiante fromDTO(EstudianteDTO d) {
        if(d == null)
            return null;

        return new Estudiante(d.getDniEstudiante(), d.getNombre(), d.getApellido(), d.getEdad(), d.getNroLibreta(), d.getGenero(), d.getCiudad());
    }

    public EstudianteDTO fromEntity(Estudiante e) {
        if(e == null)
            return null;

        return new EstudianteDTO(e.getDniEstudiante(), e.getNombre(), e.getApellido(), e.getEdad(), e.getNroLibreta(), e.getGenero(), e.getCiudad());
    }
}
