package org.example.hogwarts.dtos.response;

import lombok.Data;
import org.example.hogwarts.model.ProfesorModel;

import java.util.List;

@Data
public class CasaDto {
    private int id;
    private String nombre;
    private String fundador;
    private ProfesorModel jefe;
    private String fantasma;
    private List<String> estudianteDtos;

}
