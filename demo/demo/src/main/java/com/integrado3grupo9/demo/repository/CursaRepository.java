package com.integrado3grupo9.demo.repository;

import com.integrado3grupo9.demo.model.entities.Cursa;
import com.integrado3grupo9.demo.model.entities.CursaId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursaRepository extends JpaRepository<Cursa, CursaId> {

    @Query("SELECT c FROM Cursa c WHERE c.id.dniEstudiante = :dniEstudiante AND c.id.idCarrera = :idCarrera")
    Cursa findByEmbeddedId(Long idCarrera, Long dniEstudiante);

    @Transactional
    @Modifying
    @Query("DELETE FROM Cursa c WHERE c.id.dniEstudiante = :dniEstudiante AND c.id.idCarrera = :idCarrera")
    void deleteByEmbeddedId(Long dniEstudiante, Long idCarrera);
}
