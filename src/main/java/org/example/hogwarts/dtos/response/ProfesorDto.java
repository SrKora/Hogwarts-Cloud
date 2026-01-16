package org.example.hogwarts.dtos.response;

import lombok.Data;

import java.sql.Date;

@Data
public class ProfesorDto {
    private int id;
    private String nombre;
    private String apellido;
    private Date fecha_inicio;
}