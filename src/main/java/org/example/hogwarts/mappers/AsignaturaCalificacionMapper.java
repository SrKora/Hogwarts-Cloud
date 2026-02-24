package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.AsignaturaCalificacionDto;
import org.example.hogwarts.model.AsignaturaModel;
import org.example.hogwarts.model.EstudianteAsignaturaModel;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaCalificacionMapper {
    public AsignaturaCalificacionDto asignaturaDTOToAsignatura(EstudianteAsignaturaModel model){
        if (model == null)  {
            return null;
        }

        AsignaturaCalificacionDto dto = new AsignaturaCalificacionDto();
        dto.setAsignatura(model.getAsignatura().getNombre());
        dto.setCalificacion(model.getCalificacion());

        return dto;
    }
}