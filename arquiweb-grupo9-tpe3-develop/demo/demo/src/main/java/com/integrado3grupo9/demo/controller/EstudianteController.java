package com.integrado3grupo9.demo.controller;

import com.integrado3grupo9.demo.model.entities.Estudiante;
import com.integrado3grupo9.demo.model.dto.EstudianteDTO;
import com.integrado3grupo9.demo.model.dto.converter.ConverterEstudianteDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.integrado3grupo9.demo.services.EstudianteService;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private EstudianteService estudianteService;
    private ConverterEstudianteDTO converter;

    public EstudianteController(EstudianteService estudianteService, @Lazy ConverterEstudianteDTO converter) {
        this.estudianteService = estudianteService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> findAll() {
        List<Estudiante> estudiantes = estudianteService.findAll();
        if(!estudiantes.isEmpty())
            return new ResponseEntity<>(this.converter.fromEntity(estudiantes), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/") /*?order=desc&field=nro_libreta*/
    public ResponseEntity<List<EstudianteDTO>> findAllOrderBy(@RequestParam String order, @RequestParam String field) {
        try {
            List<Estudiante> estudiantes = estudianteService.findAllOrderBy(order, field);
            return new ResponseEntity<>(this.converter.fromEntity(estudiantes), HttpStatus.OK);
        } catch(Exception e) {;
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/") /*?genero=m*/ //LA CAGADA ES QUE LO TENEMOS REPETIDO. ES AMBIGUO (NO FUNCIO
    public ResponseEntity<List<EstudianteDTO>> findAllByGenero(@RequestParam String genero) {
        List<Estudiante> estudiantes = this.estudianteService.findAllByGenero(genero);
        if(!estudiantes.isEmpty())
            return new ResponseEntity<>(this.converter.fromEntity(estudiantes), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> save(@RequestBody EstudianteDTO estudianteDTO) {
        Estudiante estudiante = this.estudianteService.save(this.converter.fromDTO(estudianteDTO));
        return new ResponseEntity<>(this.converter.fromEntity(estudiante), HttpStatus.CREATED);
    }

    @GetMapping("/{estudianteId}")
    public ResponseEntity<EstudianteDTO> findById(@PathVariable Long estudianteId) {
        Estudiante estudiante = this.estudianteService.findById(estudianteId);
        if (estudiante != null)
            return new ResponseEntity<>(this.converter.fromEntity(estudiante), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/nroLibreta/{estudianteNroLibreta}") //LO PUSE EN LA URL (y no como parametro) PORQUE EN REALIDAD EL NRO LIBRETA TMB ES UN IDENTIFICADOR UNICO DE LOS ESTUDIANTES
    public ResponseEntity<EstudianteDTO> findByNroLibreta(@PathVariable Long estudianteNroLibreta) {
        Estudiante estudiante = this.estudianteService.findByNroLibreta(estudianteNroLibreta);
        if(estudiante != null)
            return new ResponseEntity<>(this.converter.fromEntity(estudiante), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{estudianteId}")
    public ResponseEntity<EstudianteDTO> update(@PathVariable Long estudianteId, @RequestBody EstudianteDTO estudianteDto) {
        Estudiante estudiante = this.estudianteService.update(estudianteId, this.converter.fromDTO(estudianteDto));
        if (estudiante != null)
            return new ResponseEntity<>(this.converter.fromEntity(estudiante), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{estudianteId}")
    public ResponseEntity<Boolean> delete(@PathVariable Long estudianteId) {
        if (!this.estudianteService.delete(estudianteId))
            return new ResponseEntity<>(true, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
