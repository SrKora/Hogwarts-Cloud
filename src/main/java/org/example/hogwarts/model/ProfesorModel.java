package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "profesor")
public class ProfesorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long id;

    private String nombre;
    private String apellido;
    private LocalDate fecha_inicio;

    @OneToOne
    @JoinColumn(name = "id_asignatura")
    @JsonBackReference
    private AsignaturaModel asignatura;
}