package org.example.hogwarts.dtos.request.create;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteCreateDto {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    private String nombre;

    private String apellido;

    @Min(value = 1, message = "El año debe ser al menos 1")
    private int anyoCurso;

    @NotNull(message = "Debe introducir la fecha de nacimiento")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private LocalDate fechaNacimiento;

    @Min(value = 1, message = "Debe seleccionar una casa válida")
    private int casaId;

    @NotNull(message = "La mascota es obligatoria")
    @Valid
    private MascotaCreateDto mascota;
}
