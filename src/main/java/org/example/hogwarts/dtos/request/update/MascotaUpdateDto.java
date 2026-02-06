package org.example.hogwarts.dtos.request.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MascotaUpdateDto {
    @NotNull(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotNull(message = "La especie no puede estar vacía")
    private String especie;
}
