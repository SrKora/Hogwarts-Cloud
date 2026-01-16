package org.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "profesor")
public class ProfesorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @OneToOne
    @JoinColumn(name = "asignatura", unique = true)
    private AsignaturaModel asignaturaModel;

    @Column(name = "fecha_inicio")
    private Date fecha_inicio;

    @OneToOne
    @JoinColumn(name = "casa", unique = true)
    private CasaModel casaModel;
}