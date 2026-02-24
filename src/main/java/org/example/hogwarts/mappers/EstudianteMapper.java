package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.request.create.EstudianteCreateDto;
import org.example.hogwarts.dtos.request.update.EstudianteUpdateDto;
import org.example.hogwarts.dtos.response.EstudianteDto;
import org.example.hogwarts.model.EstudianteModel;
import org.example.hogwarts.model.MascotaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            dto.setAsignaturas(
                    model.getAsignaturas().stream()
                            .map(modelEA ->
                                    asignaturaCalificacionMapper.asignaturaDTOToAsignatura(modelEA)
                            )
                            .toList()
            );
        }
        return dto;
    }

    public EstudianteModel toEntity(EstudianteCreateDto dto) {
        if (dto == null) return null;

        EstudianteModel model = new EstudianteModel();
        model.setNombre(dto.getNombre());
        model.setApellido(dto.getApellido());
        model.setAnyo_curso(dto.getAnyoCurso());
        model.setFecha_nacimiento(dto.getFechaNacimiento());
        model.setMascota(mascotaMapper.toEntity(dto.getMascota()));
        return model;
    }

    public void updateEntityFromDto(EstudianteUpdateDto dto, EstudianteModel model) {
        if (dto == null || model == null) return;

        model.setAnyo_curso(dto.getAnyoCurso());
        model.setFecha_nacimiento(dto.getFechaNacimiento());
        if (dto.getMascota() == null) {
            model.setMascota(null);
        } else {
            MascotaModel mascota = model.getMascota();
            model.setMascota(mascotaMapper.updateEntityFromDto(dto.getMascota(), mascota));
        }

    }
}