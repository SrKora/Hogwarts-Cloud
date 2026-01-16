package org.example.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "casa")
public class CasaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private int id;

    @Column(name = "nombre_casa")
    private String nombre;

    @Column(name = "fundador")
    private String fundador;

    @OneToOne(mappedBy = "casa")
    private ProfesorModel jefe;

    @Column(name = "fantasma")
    private String fantasma;

    @OneToMany(mappedBy = "casa")
    private List<EstudianteModel> estudianteModels;
}
