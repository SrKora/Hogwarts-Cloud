package org.example.hogwarts.service;

import org.example.hogwarts.dtos.request.create.EstudianteCreateDto;
import org.example.hogwarts.dtos.request.update.EstudianteUpdateDto;
import org.example.hogwarts.dtos.response.EstudianteDto;

import java.util.List;

public interface EstudianteService {
    List<EstudianteDto> obtenerTodosLosEstudiantes();
    EstudianteDto crearEstudiante(EstudianteCreateDto cdto);
    EstudianteDto actualizarEstudiante(Long id, EstudianteUpdateDto cdto);
}
