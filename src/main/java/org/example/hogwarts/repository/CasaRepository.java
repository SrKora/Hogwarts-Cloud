package org.example.hogwarts.repository;

import org.example.hogwarts.model.CasaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepository extends JpaRepository<CasaModel,Long> {
}
