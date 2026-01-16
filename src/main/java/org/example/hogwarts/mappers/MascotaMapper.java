package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.MascotaDto;
import org.example.hogwarts.model.MascotaModel;

public class MascotaMapper {
    public MascotaDto toDto(MascotaModel model) {
        if (model == null) {
            return null;
        }
        MascotaDto dto = new MascotaDto();

        dto.setId(model.getId());
        dto.setNombreMascota(model.getNombreMascota());
        dto.setEspecie(model.getEspecie());
        dto.setId_estudiante(model.getId_estudiante());
        dto.setEstudianteDto(model.getEstudianteModel());

        return dto;
    }
}
