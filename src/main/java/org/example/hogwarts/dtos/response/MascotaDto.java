package org.example.hogwarts.dtos.response;

import lombok.Data;
import org.example.hogwarts.model.EstudianteModel;

@Data
public class MascotaDto {
    private int id;
    private String nombreMascota;
    private String especie;
    private int id_estudiante;
    private EstudianteModel estudianteDto;
}
