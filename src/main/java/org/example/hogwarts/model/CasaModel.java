package org.example.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private Long id;

    private String nombre;
    private String fundador;
    private String fantasma;

    @OneToOne
    @JoinColumn(name = "id_jefe")
    private ProfesorModel jefeCasa;

    @OneToMany(mappedBy = "casa")
    private List<EstudianteModel> estudiantes;
}