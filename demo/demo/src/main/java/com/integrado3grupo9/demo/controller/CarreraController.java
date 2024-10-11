package com.integrado3grupo9.demo.controller;

import com.integrado3grupo9.demo.model.dto.CarreraDTO;
import com.integrado3grupo9.demo.model.dto.converter.ConverterCarreraDTO;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.integrado3grupo9.demo.services.CarreraService;
import com.integrado3grupo9.demo.model.entities.Carrera;
import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    private CarreraService carreraService;
    private ConverterCarreraDTO converter;

    public CarreraController(CarreraService carreraService, @Lazy ConverterCarreraDTO converte) {
        this.carreraService = carreraService;
        this.converter = converte;
    }

    public ResponseEntity<List<CarreraDTO>> findAll() {
        List<Carrera> carreras = this.carreraService.findAll();
        return new ResponseEntity<>(this.converter.fromEntity(carreras), HttpStatus.OK);
    }

}
