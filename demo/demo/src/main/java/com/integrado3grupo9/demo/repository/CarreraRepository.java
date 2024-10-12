package com.integrado3grupo9.demo.repository;

import com.integrado3grupo9.demo.model.dto.CarreraInscriptosDTO;
import com.integrado3grupo9.demo.model.dto.ReporteDTO;
import com.integrado3grupo9.demo.model.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    @Query("SELECT new com.integrado3grupo9.demo.model.dto.CarreraInscriptosDTO" +
            "(c.nombreCarrera, count(cs.id.dniEstudiante))" +
            "FROM Carrera c " +
            "JOIN Cursa cs ON c.idCarrera = cs.id.idCarrera " +
            "GROUP BY c.idCarrera " +
            "ORDER BY count(cs.id.idCarrera) DESC")
    public List<CarreraInscriptosDTO> findAllByEstudiantesInscriptosOrderByCantidad();

    @Query("SELECT new com.integrado3grupo9.demo.model.dto.ReporteDTO (" +
            "c.nombreCarrera, cs.fechaInicio, count(cs.fechaInicio), count(cs.fechaFin)) " +
            "FROM Carrera c " +
            "JOIN Cursa cs ON cs.id.idCarrera = c.idCarrera " +
            "GROUP BY c.nombreCarrera, cs.fechaInicio, cs.fechaFin "+
            "ORDER BY c.nombreCarrera, cs.fechaInicio")
    public List<ReporteDTO> generarReporte();


}
