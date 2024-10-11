package com.integrado3grupo9.demo.services;

import com.integrado3grupo9.demo.model.entities.Estudiante;
import org.springframework.stereotype.Service;
import com.integrado3grupo9.demo.repository.EstudianteRepository;

import java.util.List;

@Service
public class EstudianteService {
    private EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> findAll() {
        return repository.findAll();
    }

    public Estudiante save(Estudiante estudiante) {
        return this.repository.save(estudiante);
    }

    public Estudiante findById(Long estudianteId) {
        return this.repository.findById(estudianteId).orElse(null);
    }

    public Estudiante update(Long estudianteId, Estudiante estudiante) {
        Estudiante tmp = this.repository.findById(estudianteId).orElse(null);
        if (tmp != null) {
            tmp.setNombre(estudiante.getNombre());
            tmp.setApellido(estudiante.getApellido());
            tmp.setCiudad(estudiante.getCiudad());
            tmp.setEdad(estudiante.getEdad());
            tmp.setGenero(estudiante.getGenero());
            this.repository.save(tmp);
        }

        return tmp;
    }

    public boolean delete(Long estudianteId) {
        this.repository.deleteById(estudianteId);
        return this.repository.findById(estudianteId).isPresent();
    }

}
