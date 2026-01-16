package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.EstudianteDto;
import org.example.hogwarts.model.EstudianteModel;

public class EstudianteMapper {
    public EstudianteDto toDto(EstudianteModel model) {
        if (model == null) {
            return null;
        }
        EstudianteDto dto = new EstudianteDto();

        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setApellido(model.getApellido());
        dto.setCasaDto(model.getCasaModel());
        dto.setFecha_nacimiento(model.getFecha_nacimiento());
        dto.setAsignaturaDtos(model.getAsignaturaModels());
        dto.setMascotaDto(model.getMascotaModel());

        return dto;
    }
}
