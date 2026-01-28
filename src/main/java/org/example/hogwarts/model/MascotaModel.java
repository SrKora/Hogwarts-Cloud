package org.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mascota")
public class MascotaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long id;

    private String nombre;
    private String especie;

    @OneToOne
    @JoinColumn(name = "id_estudiante")
    private EstudianteModel estudiante;
}
