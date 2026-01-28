package org.example.hogwarts.repository;

import org.example.hogwarts.model.ProfesorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorModel, Long> {
}
