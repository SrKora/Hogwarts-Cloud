package org.example.hogwarts.dtos.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfesorDto {
    private Long id;
    private String nombre;
    private String asignatura;
    private LocalDate fechaInicio;
}