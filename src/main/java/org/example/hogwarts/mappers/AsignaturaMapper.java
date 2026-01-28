package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.AsignaturaDto;
import org.example.hogwarts.model.AsignaturaModel;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaMapper {
    public AsignaturaDto toDto(AsignaturaModel model) {
        if (model == null)  {
            return null;
        }

        AsignaturaDto dto = new AsignaturaDto();
        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setAula(model.getAula());
        dto.setObligatoria(model.isObligatoria());
        dto.setProfesor(model.getProfesor().getNombre());

        return dto;
    }
}
