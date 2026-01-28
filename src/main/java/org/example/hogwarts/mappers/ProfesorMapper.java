package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.ProfesorDto;
import org.example.hogwarts.model.ProfesorModel;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {
    public ProfesorDto toDto(ProfesorModel model) {
        if (model == null) {
            return null;
        }

        ProfesorDto dto = new ProfesorDto();

        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setAsignatura(model.getAsignatura().getNombre());
        dto.setFechaInicio(model.getFecha_inicio());

        return dto;
    }
}
