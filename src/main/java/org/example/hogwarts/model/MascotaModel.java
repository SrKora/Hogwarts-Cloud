package org.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SoftDelete;

@Data
@Entity
@SoftDelete(columnName = "deleted")
@Table(name = "mascota")
public class MascotaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long id;

    private String nombre;
    private String especie;

    @OneToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private EstudianteModel estudiante;
}
