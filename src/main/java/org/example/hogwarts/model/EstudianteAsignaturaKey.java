package org.example.hogwarts.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class EstudianteAsignaturaKey implements Serializable {
    private Long idEstudiante;
    private Long idAsignatura;
}
