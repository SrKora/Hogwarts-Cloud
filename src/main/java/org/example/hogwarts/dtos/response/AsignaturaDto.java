package org.example.hogwarts.dtos.response;

import lombok.Data;
import org.example.hogwarts.model.EstudianteModel;
import org.example.hogwarts.model.ProfesorModel;

import java.util.List;

@Data
public class AsignaturaDto {
    private int id;
    private String nombre;
    private String aula;
    private Boolean obligatoria;
    private List<EstudianteModel> estudianteDtos;
    private ProfesorModel profesorDto;
}
