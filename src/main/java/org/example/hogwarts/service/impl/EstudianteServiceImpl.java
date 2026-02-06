package org.example.hogwarts.service.impl;

import org.example.hogwarts.dtos.request.create.EstudianteCreateDto;
import org.example.hogwarts.dtos.request.update.EstudianteUpdateDto;
import org.example.hogwarts.dtos.response.EstudianteDto;
import org.example.hogwarts.mappers.EstudianteMapper;
import org.example.hogwarts.model.CasaModel;
import org.example.hogwarts.model.EstudianteAsignaturaModel;
import org.example.hogwarts.model.EstudianteModel;
import org.example.hogwarts.repository.CasaRepository;
import org.example.hogwarts.repository.EstudianteRepository;
import org.example.hogwarts.repository.MascotaRepository;
import org.example.hogwarts.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepo;
    private final EstudianteMapper estudianteMapper;
    private final CasaRepository casaRepo;
    private final MascotaRepository mascotaRepo; // 1. Añade esto

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepo,
                                 EstudianteMapper estudianteMapper,
                                 CasaRepository casaRepo,
                                 MascotaRepository mascotaRepo) { // 2. Inyéctalo
        this.estudianteRepo = estudianteRepo;
        this.estudianteMapper = estudianteMapper;
        this.casaRepo = casaRepo;
        this.mascotaRepo = mascotaRepo;
    }


    @Override
    public List<EstudianteDto> obtenerTodosLosEstudiantes() {
        return estudianteRepo.findAll().stream()
                .map(estudianteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public EstudianteDto crearEstudiante(EstudianteCreateDto cdto) {
        EstudianteModel model = estudianteMapper.toEntity(cdto);

        CasaModel casa = casaRepo.findById((long) cdto.getCasaId())
                .orElseThrow(() -> new RuntimeException("La casa no existe"));
        model.setCasa(casa);

        if (model.getMascota() != null) {
            model.getMascota().setEstudiante(model);
        }

        EstudianteModel estudianteGuardado = estudianteRepo.save(model);

        return estudianteMapper.toDto(estudianteGuardado);
    }


    @Override
    @Transactional
    public EstudianteDto actualizarEstudiante(Long id, EstudianteUpdateDto udto) {
        EstudianteModel estudiante = estudianteRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estudiante no encontrado con id: " + id));

        estudianteMapper.updateEntityFromDto(udto, estudiante);

        estudiante.getMascota().setEstudiante(estudiante);

        EstudianteModel estudianteActualizado = estudianteRepo.save(estudiante);

        return estudianteMapper.toDto(estudianteActualizado);
    }

    @Override
    @Transactional
    public void eliminarEstudiante(Long id) {
        EstudianteModel estudiante = estudianteRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("El usuario con ID " + id + " no existe."));

        if (!(estudiante.getMascota() == null)) {
            mascotaRepo.delete(estudiante.getMascota());
        }

        estudianteRepo.delete(estudiante);
    }
}
