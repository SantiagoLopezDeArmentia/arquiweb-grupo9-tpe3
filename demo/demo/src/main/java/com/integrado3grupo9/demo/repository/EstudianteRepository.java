package com.integrado3grupo9.demo.repository;

import com.integrado3grupo9.demo.model.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query("select e from Estudiante e")
    public List<Estudiante> consulta();

}
