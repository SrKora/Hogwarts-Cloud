package org.example.hogwarts.dtos.response;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class EstudianteDto {
    private int id;
    private String nombre;
    private String casaDto;
    private int anyo_curso;
    private Date fecha_nacimiento;
    private List<AsignaturaDto> asignaturaDtos;
    private MascotaDto mascotaDto;

}
