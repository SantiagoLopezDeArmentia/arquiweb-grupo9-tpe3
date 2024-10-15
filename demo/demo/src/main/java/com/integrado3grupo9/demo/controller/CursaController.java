package com.integrado3grupo9.demo.controller;

import com.integrado3grupo9.demo.model.dto.CursaDTO;
import com.integrado3grupo9.demo.model.dto.CursaIdDTO;
import com.integrado3grupo9.demo.model.dto.converter.ConverterCursaDTO;
import com.integrado3grupo9.demo.model.dto.converter.ConverterCursaIdDTO;
import com.integrado3grupo9.demo.model.entities.Cursa;
import com.integrado3grupo9.demo.services.CursaService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursadas")
public class CursaController {

    private CursaService cursaService;
    private ConverterCursaDTO converter;
    private ConverterCursaIdDTO converterID;

    public CursaController(CursaService cursaService, @Lazy ConverterCursaDTO converter, @Lazy ConverterCursaIdDTO converterID) {
        this.cursaService = cursaService;
        this.converter = converter;
        this.converterID = converterID;
    }

    @GetMapping
    public ResponseEntity<List<CursaDTO>> findAll() {
        List<Cursa> cursadas = this.cursaService.findAll();
        if (cursadas.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(this.converter.fromEntity(cursadas), HttpStatus.OK);
    }

    @PostMapping("/matricular/estudiante/{estudianteId}/carrera/{carreraId}")
    public ResponseEntity<CursaDTO> save(@PathVariable Long estudianteId, @PathVariable Long carreraId) {
        Cursa cursa = this.cursaService.save(estudianteId, carreraId);
        if (cursa != null)
            return new ResponseEntity<>(this.converter.fromEntity(cursa), HttpStatus.CREATED);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/estudiante/{estudianteId}/carrera/{carreraId}")
    public ResponseEntity<CursaDTO> findById(@PathVariable Long estudianteId, @PathVariable Long carreraId) {
        Cursa cursa = this.cursaService.findById(estudianteId, carreraId);
        if (cursa != null)
            return new ResponseEntity<>(this.converter.fromEntity(cursa), HttpStatus.FOUND);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/estudiante/{estudianteId}/carrera/{carreraId}")
    public ResponseEntity<CursaDTO> updateById(@RequestBody CursaIdDTO body, @PathVariable Long estudianteId, @PathVariable Long carreraId) {
        Cursa cursa = this.cursaService.updateById(this.converterID.fromDTO(body), estudianteId, carreraId);
        if (cursa != null)
            return new ResponseEntity<>(this.converter.fromEntity(cursa), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/estudiante/{estudianteId}/carrera/{carreraId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long estudianteId, @PathVariable Long carreraId) {
        boolean deleted = this.cursaService.deleteById(estudianteId, carreraId);
        if (!deleted)
            return new ResponseEntity<>(deleted, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}