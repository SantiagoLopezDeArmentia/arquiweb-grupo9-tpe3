package com.integrado3grupo9.demo.services;

import com.integrado3grupo9.demo.model.entities.Carrera;
import org.springframework.stereotype.Service;
import com.integrado3grupo9.demo.repository.CarreraRepository;

import java.util.List;

@Service
public class CarreraService {

    private CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public List<Carrera> findAll() {
        return this.carreraRepository.findAll();
    }

    public Carrera save(Carrera carrera) {
        return this.carreraRepository.save(carrera);
    }

    public Carrera findById(Long id) {
        return this.carreraRepository.findById(id).orElse(null);
    }

    public Carrera update(Long carreraId, Carrera carrera) {
        Carrera tmp = this.carreraRepository.findById(carreraId).orElse(null);
        if (tmp != null) {
            tmp.setNombreCarrera(carrera.getNombreCarrera());
            this.save(tmp);
        }
        return tmp;
    }

    public void delete(Long carreraId) {
        this.carreraRepository.deleteById(carreraId);
    }

}
