package org.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante_asignatura")
public class EstudianteAsignaturaModel {

    @EmbeddedId
    private EstudianteAsignaturaKey id;

    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumn(name = "id_estudiante")
    private EstudianteModel estudiante; // Nombre limpio

    @ManyToOne
    @MapsId("idAsignatura")
    @JoinColumn(name = "id_asignatura")
    private AsignaturaModel asignatura; // Nombre limpio

    private int calificacion;
}