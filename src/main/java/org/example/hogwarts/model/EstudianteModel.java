package org.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "estudiante")
public class EstudianteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @ManyToOne
    @JoinColumn(name = "casa_id")
    private CasaModel casaModel;

    @Column(name = "anyo_curso")
    private int anyo_curso;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @ManyToMany
    @JoinTable(
            name = "estudiante_asignatura",
            joinColumns = @JoinColumn(name = "id_estudiante"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura")
    )
    private List<AsignaturaModel> asignaturaModels;

    @OneToOne
    @JoinColumn(name = "mascota", unique = true)
    private MascotaModel mascotaModel;
}