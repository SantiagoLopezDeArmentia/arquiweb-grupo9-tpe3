package com.integrado3grupo9.demo.services;

import com.integrado3grupo9.demo.model.entities.Carrera;
import com.integrado3grupo9.demo.model.entities.Cursa;
import com.integrado3grupo9.demo.model.entities.CursaId;
import com.integrado3grupo9.demo.model.entities.Estudiante;
import com.integrado3grupo9.demo.repository.CarreraRepository;
import com.integrado3grupo9.demo.repository.CursaRepository;
import com.integrado3grupo9.demo.repository.EstudianteRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class CursaService {

    private EstudianteRepository estudianteRepository;
    private CarreraRepository carreraRepository;
    private CursaRepository cursaRepository;


    public CursaService (EstudianteRepository estudianteRepository, @Lazy CarreraRepository carreraRepository, @Lazy CursaRepository cursaRepository) {
        this.estudianteRepository = estudianteRepository;
        this.carreraRepository = carreraRepository;
        this.cursaRepository = cursaRepository;
    }

    public Cursa save(Long estudianteId, Long carreraId) {
        Estudiante estudiante = this.estudianteRepository.findById(estudianteId).orElse(null);
        Carrera carrera = this.carreraRepository.findById(carreraId).orElse(null);

        if (estudiante != null && carrera != null) {
            CursaId cursaId = new CursaId(estudianteId, carreraId);
            Cursa cursa = new Cursa(cursaId, estudiante, carrera, 2, new Date());
            estudiante.addCursada(cursa);
            carrera.addEstudiantesMatriculados(cursa);
            return this.cursaRepository.save(cursa);
        }
        return null;
    }
}
