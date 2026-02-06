package org.example.hogwarts.dtos.request.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MascotaCreateDto {
    @NotBlank(message = "No puede estar el nombre en blanco")
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    private String nombre;
    @NotBlank(message = "No puede estar el nombre en blanco")
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    private String especie;
}
