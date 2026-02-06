package org.example.hogwarts.mappers;

import jakarta.validation.constraints.NotBlank;
import org.example.hogwarts.dtos.request.create.MascotaCreateDto;
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

    public MascotaModel toEntity(MascotaCreateDto dto) {
        if (dto == null) return null;

        MascotaModel model = new MascotaModel();
        model.setNombre(dto.getNombre());
        model.setEspecie(dto.getEspecie());
        return model;
    }

    public MascotaModel toEntitys(MascotaDto dto) {
        if (dto == null) return null;

        MascotaModel model = new MascotaModel();
        model.setNombre(dto.getNombre());
        model.setEspecie(dto.getEspecie());
        return model;
    }

    public void updateEntityFromDto(MascotaDto dto, MascotaModel model) {
        if (dto == null || model == null) return;

        model.setNombre(dto.getNombre());
        model.setEspecie(dto.getEspecie());
    }
}
