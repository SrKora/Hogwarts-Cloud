package org.example.hogwarts.dtos.request.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MascotaUpdateDto {
    private String nombre;
    private String especie;
}
