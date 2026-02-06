package org.example.hogwarts.dtos.request.update;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EstudianteUpdateDto {
    @NotNull(message = "El año del curso no puede estar vacio")
    private int anyoCurso;
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;
    @NotNull(message = "La mascota es obligatoria")
    @Valid
    private MascotaUpdateDto mascota;
}
