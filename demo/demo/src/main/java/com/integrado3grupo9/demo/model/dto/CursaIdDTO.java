package com.integrado3grupo9.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
@Getter
@Setter
public class CursaIdDTO {
    private Long dniEstudiante;
    private Long idCarrerra;
}
