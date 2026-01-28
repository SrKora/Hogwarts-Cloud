package org.example.hogwarts.dtos.response;

import lombok.Data;

@Data
public class MascotaDto {
    private Long id;
    private String nombre;
    private String especie;
    private String estudiante;
}
