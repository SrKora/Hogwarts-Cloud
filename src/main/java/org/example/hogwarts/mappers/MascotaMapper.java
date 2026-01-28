package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.MascotaDto;
import org.example.hogwarts.model.MascotaModel;
import org.springframework.stereotype.Component;

@Component
public class MascotaMapper {
    public MascotaDto toDto(MascotaModel model) {
        if (model == null)  {
            return null;
        }

        MascotaDto dto = new MascotaDto();
        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setEspecie(model.getEspecie());
        if (model.getEstudiante() != null) {
            dto.setEstudiante(model.getEstudiante().getNombre());
        }

        return dto;
    }
}
