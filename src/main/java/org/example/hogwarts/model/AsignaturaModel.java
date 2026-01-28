package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "asignatura")
public class AsignaturaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Long id;

    private String nombre;
    private String aula;
    private boolean obligatoria;

    @OneToOne(mappedBy = "asignatura")
    @JsonBackReference
    private ProfesorModel profesor;

    @OneToMany(mappedBy = "asignatura")
    private List<EstudianteAsignaturaModel> asignaturas;
}