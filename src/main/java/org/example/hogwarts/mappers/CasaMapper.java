package org.example.hogwarts.mappers;

import org.example.hogwarts.dtos.response.CasaDto;
import org.example.hogwarts.model.CasaModel;

public class CasaMapper {
    public CasaDto toDto(CasaModel model) {
        if (model == null) {
            return null;
        }
        CasaDto dto = new CasaDto();

        dto.setId(model.getId());
        dto.setNombre(model.getNombre());
        dto.setFundador(model.getFundador());
        dto.setJefe(model.getJefe());
        dto.setFantasma(model.getFantasma());
        dto.setEstudianteDtos(model.getEstudianteModels());

        return dto;
    }
}
