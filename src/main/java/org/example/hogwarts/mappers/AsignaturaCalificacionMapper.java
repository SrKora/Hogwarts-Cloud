package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.AsignaturaCalificacionDto;
import org.example.hogwarts.model.AsignaturaModel;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaCalificacionMapper {
    public AsignaturaCalificacionDto asignaturaDTOToAsignatura(AsignaturaModel model){
        if (model == null)  {
            return null;
        }

        AsignaturaCalificacionDto dto = new AsignaturaCalificacionDto();
        dto.setAsignatura(model.getNombre());
        dto.setCalificacion(0.0);

        return dto;
    }
}