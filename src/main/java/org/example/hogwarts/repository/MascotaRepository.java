package org.example.hogwarts.repository;

import org.example.hogwarts.model.MascotaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<MascotaModel,Long> {
}
