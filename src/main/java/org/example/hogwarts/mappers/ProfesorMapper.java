package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.ProfesorDto;
import org.example.hogwarts.model.ProfesorModel;

public class ProfesorMapper {
    public ProfesorDto toDto(ProfesorModel model) {
        if (model == null) {
            return null;
        }

        ProfesorDto dto = new ProfesorDto();

        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setApellido(model.getApellido());
        dto.setAsignaturaDto(model.getAsignaturaModel());
        dto.setFecha_inicio(model.getFecha_inicio());
        dto.setCasaDto(model.getCasaModel());
    }
}
