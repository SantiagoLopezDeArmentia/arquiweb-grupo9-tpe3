package com.integrado3grupo9.demo.controller;

import com.integrado3grupo9.demo.model.dto.CarreraDTO;
import com.integrado3grupo9.demo.model.dto.CarreraInscriptosDTO;
import com.integrado3grupo9.demo.model.dto.ReporteDTO;
import com.integrado3grupo9.demo.model.dto.converter.ConverterCarreraDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.integrado3grupo9.demo.services.CarreraService;
import com.integrado3grupo9.demo.model.entities.Carrera;
import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    private CarreraService carreraService;
    private ConverterCarreraDTO converter;

    public CarreraController(CarreraService carreraService, @Lazy ConverterCarreraDTO converter) {
        this.carreraService = carreraService;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<CarreraDTO>> findAll() {
        List<Carrera> carreras = this.carreraService.findAll();
        return new ResponseEntity<>(this.converter.fromEntity(carreras), HttpStatus.OK);
    }

    /* Resuelve ejercicio F */
    @GetMapping("/inscriptos")
    public ResponseEntity<List<CarreraInscriptosDTO>> findAllByEstudiantesInscriptosOrderByCantidad() {
        List<CarreraInscriptosDTO> list = this.carreraService.findAllByEstudiantesInscriptosOrderByCantidad();
        if(list.isEmpty()) {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* Resuelve el servicio H */
    @GetMapping("/reporte")
    public ResponseEntity<List<ReporteDTO>> findAllByGenerarReporte() {
        List<ReporteDTO> reporte = this.carreraService.generarReporte();
        if (reporte.isEmpty()) {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    @GetMapping("/{carreraId}")
    public ResponseEntity<CarreraDTO> findById(@PathVariable Long carreraId) {
        Carrera carrera = this.carreraService.findById(carreraId);
        if(carrera != null)
            return new ResponseEntity<>(this.converter.fromEntity(carrera), HttpStatus.FOUND);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CarreraDTO> save(@RequestBody CarreraDTO carreraDTO) {
        Carrera carrera = this.carreraService.save(this.converter.fromDTO(carreraDTO));
        return new ResponseEntity<>(this.converter.fromEntity(carrera), HttpStatus.CREATED);
    }

    @PutMapping("/{carreraId}")
    public ResponseEntity<CarreraDTO> updateById(@RequestBody CarreraDTO body, @PathVariable Long carreraId) {
        Carrera carrera = this.carreraService.updateById(carreraId, this.converter.fromDTO(body));
        if(carrera != null)
            return new ResponseEntity<>(this.converter.fromEntity(carrera), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{carreraId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long carreraId) {
        boolean deleted = this.carreraService.deleteById(carreraId);
        if(!deleted)
            return new ResponseEntity<>(deleted, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}