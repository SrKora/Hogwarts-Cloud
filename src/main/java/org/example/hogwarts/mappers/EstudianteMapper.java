package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.EstudianteDto;
import org.example.hogwarts.dtos.response.MascotaDto;
import org.example.hogwarts.model.EstudianteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EstudianteMapper {
    @Autowired
    private MascotaMapper mascotaMapper;

    @Autowired
    private AsignaturaCalificacionMapper asignaturaCalificacionMapper;
    public EstudianteDto toDto(EstudianteModel model) {
        if ( model == null ) {
            return null;
        }

        EstudianteDto dto = new EstudianteDto();

        dto.setId(model.getIdEstudiante());
        dto.setNombre(model.getNombre());
        dto.setAnyoCurso(model.getAnyo_curso());
        dto.setFechaNacimiento(model.getFecha_nacimiento());
        dto.setCasa(model.getCasa().getNombre());
        dto.setMascota(mascotaMapper.toDto(model.getMascota()));
        if (model.getAsignaturas() != null) {
            dto.setAsignaturas(model.getAsignaturas().stream()
                    .map(asignatura -> asignaturaCalificacionMapper.asignaturaDTOToAsignatura(asignatura.getAsignatura()))
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}