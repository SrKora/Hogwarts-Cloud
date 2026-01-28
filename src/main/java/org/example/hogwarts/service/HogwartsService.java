package org.example.hogwarts.service;

import org.example.hogwarts.dtos.response.*;
import org.example.hogwarts.mappers.*;
import org.example.hogwarts.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HogwartsService {

    @Autowired private EstudianteRepository estudianteRepo;


    @Autowired private EstudianteMapper estudianteMapper;


    // --- ESTUDIANTES ---
    public List<EstudianteDto> listarEstudiantes() {
        return estudianteRepo.findAll().stream()
                .map(estudianteMapper::toDto)
                .collect(Collectors.toList());
    }
}