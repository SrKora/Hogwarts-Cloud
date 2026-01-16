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
    private int id;

    @Column(name = "nombre_mascota")
    private String nombreMascota;

    @Column(name = "especie")
    private String especie;

    @Column(name = "id_estudiante")
    private int id_estudiante;

    @OneToOne(mappedBy = "mascota")
    private EstudianteModel estudianteModel;
}
