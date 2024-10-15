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
    public ResponseEntity<List<EstudianteDTO>> findAll(@RequestParam(required = false) String genero,
                                                       @RequestParam(required = false) String order,
                                                       @RequestParam(required = false) String field,
                                                       @RequestParam(required = false) String ciudad,
                                                       @RequestParam(required = false) String nombreCarrera
        ) {

        /* Resuelve ejercicio E */
        if (genero != null) {
            return findAllByGenero(genero);
        }
        /* Resulve ejercicio C */
        if (order != null && field != null) {
            return findAllOrderBy(order, field);
        }
        if(ciudad != null && nombreCarrera != null) {
            return findAllByCarreraFilterByCiudad(ciudad, nombreCarrera);
        }
        /* Resuelve ejercicio */
        List<Estudiante> estudiantes = estudianteService.findAll();
        if(!estudiantes.isEmpty())
            return new ResponseEntity<>(this.converter.fromEntity(estudiantes), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /* Resuelve ejercicio E*/
    public ResponseEntity<List<EstudianteDTO>> findAllByGenero(String genero) {
        List<Estudiante> estudiantes = this.estudianteService.findAllByGenero(genero);
        if(!estudiantes.isEmpty())
            return new ResponseEntity<>(this.converter.fromEntity(estudiantes), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /* Resuelve ejercicio C*/
    public ResponseEntity<List<EstudianteDTO>> findAllOrderBy(String order, String field) {
        try {
            List<Estudiante> estudiantes = estudianteService.findAllOrderBy(order, field);
            return new ResponseEntity<>(this.converter.fromEntity(estudiantes), HttpStatus.OK);
        } catch(Exception e) {;
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<EstudianteDTO>> findAllByCarreraFilterByCiudad(
            String ciudad, String nombreCarrera) {
        List<Estudiante> estudiante = this.estudianteService.findAllByCarreraFilterByCiudad(ciudad, nombreCarrera);
        if (!estudiante.isEmpty()) {
            return new ResponseEntity<>(this.converter.fromEntity(estudiante), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    /* ####################### */
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
    public ResponseEntity<List<EstudianteDTO>> findByNroLibreta(@PathVariable Long estudianteNroLibreta) {
        List<Estudiante> estudiantes = this.estudianteService.findByNroLibreta(estudianteNroLibreta);
        if(!estudiantes.isEmpty()) {
            return new ResponseEntity<>(this.converter.fromEntity(estudiantes), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
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
