package com.integrado3grupo9.demo.repository;

import com.integrado3grupo9.demo.model.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e WHERE e.nroLibreta = :nroLibreta")
    public Optional<Estudiante> findByNroLibreta(Long nroLibreta);

    @Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
    public List<Estudiante> findAllByGenero(String genero);

}
