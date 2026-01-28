package org.example.hogwarts.dtos.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EstudianteDto {
    private Long id;
    private String nombre;
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private String casa;
    private MascotaDto mascota;
    private List<AsignaturaCalificacionDto> asignaturas;
}
