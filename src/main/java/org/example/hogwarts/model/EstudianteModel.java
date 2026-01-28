package org.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "estudiante")
public class EstudianteModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;

    private String nombre;
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_casa")
    private CasaModel casa;

    private int anyo_curso;
    private LocalDate fecha_nacimiento;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteAsignaturaModel> asignaturas;

    @OneToOne(mappedBy = "estudiante")
    private MascotaModel mascota;
}