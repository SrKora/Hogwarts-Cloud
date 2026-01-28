package org.example.hogwarts.repository;

import org.example.hogwarts.model.AsignaturaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<AsignaturaModel,Long> {
}
