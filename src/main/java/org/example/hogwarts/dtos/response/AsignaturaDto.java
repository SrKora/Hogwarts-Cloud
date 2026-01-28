package org.example.hogwarts.dtos.response;

import lombok.Data;

@Data
public class AsignaturaDto {
    private Long id;
    private String nombre;
    private String aula;
    private boolean obligatoria;
    private String profesor;
}
