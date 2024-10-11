package com.integrado3grupo9.demo.controller;

import com.integrado3grupo9.demo.model.dto.CarreraInscriptosDTO;
import com.integrado3grupo9.demo.model.dto.CursaDTO;
import com.integrado3grupo9.demo.model.dto.converter.ConverterCarreraInscriptosDTO;
import com.integrado3grupo9.demo.model.dto.converter.ConverterCursaDTO;
import com.integrado3grupo9.demo.services.CursaService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursadas")
public class CursaController {

    private CursaService cursaService;
    private ConverterCursaDTO converter;

    public CursaController(CursaService cursaService, @Lazy ConverterCursaDTO converter) {
        this.cursaService = cursaService;
        this.converter = converter;
    }


    @PostMapping("/matricular") /* estudianteId={estudianteId}&carreraId={carreraId}*/
    public ResponseEntity<CursaDTO> save(@RequestParam Long estudianteId, @RequestParam Long carreraId) {
        return new ResponseEntity<>(this.converter.fromEntity(this.cursaService.save(estudianteId, carreraId)), HttpStatus.OK);
    }

}
