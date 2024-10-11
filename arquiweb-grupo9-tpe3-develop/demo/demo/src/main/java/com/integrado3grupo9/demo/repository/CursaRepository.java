package com.integrado3grupo9.demo.repository;

import com.integrado3grupo9.demo.model.entities.Cursa;
import com.integrado3grupo9.demo.model.entities.CursaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursaRepository extends JpaRepository<Cursa, CursaId> {
}
