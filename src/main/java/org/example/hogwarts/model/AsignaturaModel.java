package org.example.hogwarts.model;

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
    private int id;

    @Column(name = "nombre_asignatura")
    private String nombre;

    @Column(name = "aula")
    private String aula;

    @Column(name = "obligatoria")
    private Boolean obligatoria;

    @ManyToMany(mappedBy = "asignaturas")
    private List<EstudianteModel> estudianteModels;

    @OneToOne(mappedBy = "asignatura")
    private ProfesorModel profesorModel;
}
