package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.CasaDto;
import org.example.hogwarts.model.CasaModel;
import org.example.hogwarts.model.EstudianteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CasaMapper {
    @Autowired
    private ProfesorMapper profesorMapper;
    public CasaDto toDto(CasaModel model) {
        if (model == null) {
            return null;
        }

        CasaDto dto = new CasaDto();

        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setFundador(model.getFundador());
        if (model.getJefeCasa() != null){
            dto.setJefe(profesorMapper.toDto(model.getJefeCasa()));
        }
        if (model.getEstudiantes() != null){
            dto.setEstudiantes(model.getEstudiantes().stream().map(EstudianteModel::getNombre).toList());
        }

        return dto;
    }
}
