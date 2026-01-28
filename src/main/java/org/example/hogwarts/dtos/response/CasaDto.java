package org.example.hogwarts.dtos.response;

import lombok.Data;

import java.util.List;

@Data
public class CasaDto {
    private Long id;
    private String nombre;
    private String fundador;
    private ProfesorDto jefe;
    private List<String> estudiantes;
}
